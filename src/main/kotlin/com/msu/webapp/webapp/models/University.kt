package com.msu.webapp.webapp.models

import javax.persistence.*

//@Entity
@Table(name = "universities")
data class University(
        var name: String? = null,

        var address: String? = null,

        @OneToMany(fetch = FetchType.EAGER,mappedBy = "university",cascade = [CascadeType.ALL])
        val offers: MutableList<Offer> = mutableListOf(),

        @OneToMany(fetch = FetchType.EAGER,mappedBy = "university",cascade = [CascadeType.ALL])
        val faculties: MutableList<Faculty> = mutableListOf()

) {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0
}