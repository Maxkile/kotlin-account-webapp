package com.msu.webapp.webapp.models

import com.msu.webapp.webapp.constants.Constants
import com.msu.webapp.webapp.enums.Roles
import org.intellij.lang.annotations.Pattern
import org.jetbrains.annotations.NotNull
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.nio.file.attribute.UserPrincipal
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        var userName: String,

        @Pattern(Constants.MAIL_PATTERN)
        var email: String,
        var passwd: String,

        var birthDate: Date,
        var role: Roles,

        @ManyToMany
        val universities: MutableList<University> = mutableListOf(),

        @ManyToMany
        val faculties: MutableList<Faculty> = mutableListOf(),

        @OneToMany
        val offers: MutableList<Offer> = mutableListOf()
) : UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf(role)

    override fun isEnabled() = true

    override fun getUsername() = userName

    override fun getPassword() = passwd

    override fun isCredentialsNonExpired() = true

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun equals(other: Any?): Boolean {
        if (this === other) return true;
        if (other == null || this.javaClass != other.javaClass) return false;
        val user : User = other as User;
        return Objects.equals(username, user.username) &&
                Objects.equals(email, user.email);
    }

    override fun hashCode(): Int {
        var result = userName.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + passwd.hashCode()
        result = 31 * result + id
        return result
    }
}