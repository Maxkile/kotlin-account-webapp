package com.msu.webapp.webapp.repositories

import com.msu.webapp.webapp.models.University
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UniversityRepository: JpaRepository<University,Int>{
    fun findUniversityById(id: Int): University
    fun findUniversityByAddress(address: String): University
    fun findUniversityByName(name: String): University
}