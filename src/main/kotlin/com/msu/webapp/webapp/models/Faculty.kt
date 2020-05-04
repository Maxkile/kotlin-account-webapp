package com.msu.webapp.webapp.models;

import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
@Table(name = "faculties")
data class Faculty(
        var name: String? = null,
        var places: Int? = null,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "university_id", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        val university: University,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "offer_id", nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        val offer: Offer
) {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0
}
