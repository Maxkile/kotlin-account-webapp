package com.msu.webapp.webapp.models

import org.jetbrains.annotations.NotNull
import javax.persistence.*

//@Entity
@Table(name = "universities")
data class University(
        var name: String,

        var adress: String,

        @OneToMany
        var faculties: MutableList<Any> = mutableListOf(),

        @ManyToMany
        var enrollees: MutableList<User> = mutableListOf()
) {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int = 0
}