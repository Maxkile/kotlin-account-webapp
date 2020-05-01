package com.msu.webapp.webapp.models;

import javax.persistence.*

//@Entity
@Table(name = "universities")
data class Faculty(
        var name: String,
        var places: Int,

        @ManyToOne
        var university: University,

        @ManyToMany
        var students: MutableList<Faculty> = mutableListOf()
) {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0
}
