package com.msu.webapp.webapp.services.faculty

import com.msu.webapp.webapp.models.Faculty
import com.msu.webapp.webapp.models.Offer
import com.msu.webapp.webapp.models.University


interface FacultyService {
    fun save(faculty: Faculty): Unit
    fun delete(faculty: Faculty): Unit
    fun findFacultyById(id: Int): Faculty
    fun findFacultyByName(name: String): Faculty
    fun findFacultiesByUniversity(university: University): List<Faculty>
    fun findFacultiesByOffer(offer: Offer): List<Faculty>
}