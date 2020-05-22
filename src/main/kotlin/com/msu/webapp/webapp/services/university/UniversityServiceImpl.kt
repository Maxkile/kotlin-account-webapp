package com.msu.webapp.webapp.services.university

import com.msu.webapp.webapp.models.University
import com.msu.webapp.webapp.repositories.UniversityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UniversityServiceImpl(
        @Autowired
        private val universityRepository: UniversityRepository

): UniversityService {
    override fun save(university: University) {
        universityRepository.save(university)
    }

    override fun delete(university: University) {
        universityRepository.delete(university)
    }

    override fun findUniversityById(id: Int) = universityRepository.findUniversityById(id)

    override fun findUniversityByAddress(address: String) = universityRepository.findUniversityByAddress(address)

    override fun findUniversityByName(name: String) = universityRepository.findUniversityByName(name)
}