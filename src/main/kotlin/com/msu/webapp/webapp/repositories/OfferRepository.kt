package com.msu.webapp.webapp.repositories

import com.msu.webapp.webapp.models.Offer
import com.msu.webapp.webapp.models.University
import com.msu.webapp.webapp.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OfferRepository: JpaRepository<Offer, Int> {
    fun findOfferById(id: Int): Offer
    fun findOfferByCreatedBefore(created: Date): Offer
    fun findOffersByUniversity(university: University): List<Offer>
    fun findOffersByUser(user: User): List<Offer>
}