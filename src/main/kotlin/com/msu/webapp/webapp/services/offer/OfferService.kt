package com.msu.webapp.webapp.services.offer

import com.msu.webapp.webapp.models.Offer
import com.msu.webapp.webapp.models.University
import com.msu.webapp.webapp.models.User
import java.util.*

interface OfferService{
    fun save(offer: Offer): Unit
    fun delete(offer: Offer): Unit
    fun findOfferById(id: Int): Offer
    fun findOfferByCreatedBefore(created: Date): Offer
    fun findOffersByUniversity(university: University): List<Offer>
    fun findOffersByUser(user: User): List<Offer>
}