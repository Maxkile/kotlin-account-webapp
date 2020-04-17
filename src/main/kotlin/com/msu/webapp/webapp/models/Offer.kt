package com.msu.webapp.webapp.models

import javax.persistence.*

@Entity
@Table(name = "offers")
data class Offer(
        @OneToOne
        var university: University,

        @OneToOne
        var faculty: Faculty,

        @ManyToOne
        var enrollee: User

) {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0
}