package com.msu.webapp.webapp.repositories

import com.msu.webapp.webapp.models.Faculty
import com.msu.webapp.webapp.models.Offer
import com.msu.webapp.webapp.models.University
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FacultyRepository: JpaRepository<Faculty, Int> {
    fun findFacultyById(id: Int): Faculty
    fun findFacultyByName(name: String): Faculty
    fun findFacultiesByUniversity(university: University): List<Faculty>
    fun findFacultiesByOffer(offer: Offer): List<Faculty>
}