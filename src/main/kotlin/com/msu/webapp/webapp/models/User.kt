package com.msu.webapp.webapp.models

import com.msu.webapp.webapp.enums.Roles
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*

/*
    Username is email itself
 */
@Entity
@Table(name = "users")
data class User(

        //@Pattern(Constants.MAIL_PATTERN)
        @JvmField
        var username: String? = null,

        var firstName: String? = null,
        var lastName: String? = null,

        @JvmField
        var password: String? = null,

//        @Pattern(Constants.PHONE_NUMBER_PATTERN)
        var phoneNumber: String? = null,

        @DateTimeFormat(pattern = "dd/MM/yyyy")
        var birthDate: Date? = null,

        var role: Roles = Roles.USER,

        @OneToMany(fetch = FetchType.EAGER,mappedBy = "user",cascade = [CascadeType.ALL])
        val offers: MutableList<Offer> = mutableListOf()

) : UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf(role)

    override fun isEnabled() = true

    override fun getPassword() = password

    override fun isCredentialsNonExpired() = true

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun getUsername() = username

    override fun equals(other: Any?): Boolean {
        if (this === other) return true;
        if (other == null || this.javaClass != other.javaClass) return false;
        val user : User = other as User;
        return Objects.equals(username, user.username) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName)
    }

    override fun hashCode(): Int {
        var result = username.hashCode()
        result = 31 * result + password.hashCode()
        result = 31 * result + id
        return result
    }
}