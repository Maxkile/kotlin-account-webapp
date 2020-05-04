package com.msu.webapp.webapp.services.faculty

import com.msu.webapp.webapp.models.Faculty
import com.msu.webapp.webapp.models.Offer
import com.msu.webapp.webapp.models.University
import com.msu.webapp.webapp.repositories.FacultyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FacultyServiceImpl(
        @Autowired
        private val facultyRepository: FacultyRepository
): FacultyService{
    override fun save(faculty: Faculty) {
        facultyRepository.save(faculty)
    }

    override fun delete(faculty: Faculty) {
        facultyRepository.delete(faculty)
    }

    override fun findFacultyById(id: Int) = facultyRepository.findFacultyById(id)

    override fun findFacultyByName(name: String) = facultyRepository.findFacultyByName(name)

    override fun findFacultiesByUniversity(university: University) = facultyRepository.findFacultiesByUniversity(university)

    override fun findFacultiesByOffer(offer: Offer) = facultyRepository.findFacultiesByOffer(offer)
}