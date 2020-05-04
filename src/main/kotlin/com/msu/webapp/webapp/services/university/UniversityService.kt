package com.msu.webapp.webapp.services.university

import com.msu.webapp.webapp.models.University


interface UniversityService {
    fun save(university: University): Unit
    fun delete(university: University): Unit
    fun findUniversityById(id: Int): University
    fun findUniversityByAddress(address: String): University
    fun findUniversityByName(name: String): University
}