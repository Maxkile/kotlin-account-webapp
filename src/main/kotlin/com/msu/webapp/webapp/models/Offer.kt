package com.msu.webapp.webapp.models

import com.msu.webapp.webapp.enums.OfferStatus
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import org.springframework.format.annotation.DateTimeFormat
import java.util.*
import javax.persistence.*

//@Entity
@Table(name = "offers")
data class Offer(

        var status: OfferStatus = OfferStatus.CREATED,

        @DateTimeFormat(pattern = "dd/MM/yyyy")
        var created: Date? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "user_id", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        val user: User,


        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "university_id", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        val university: University,

        @OneToMany(fetch = FetchType.EAGER,mappedBy = "offer",cascade = [CascadeType.ALL])
        val faculties: MutableList<Faculty> = mutableListOf()
) {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0
}