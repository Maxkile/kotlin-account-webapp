package com.msu.webapp.webapp.services.offer

import com.msu.webapp.webapp.models.Offer
import com.msu.webapp.webapp.models.University
import com.msu.webapp.webapp.models.User
import com.msu.webapp.webapp.repositories.OfferRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class OfferServiceImpl(
        @Autowired
        private val offerRepository: OfferRepository

): OfferService{

    override fun save(offer: Offer) {
        offerRepository.save(offer)
    }

    override fun delete(offer: Offer) {
        offerRepository.delete(offer)
    }

    override fun findOfferById(id: Int) = offerRepository.findOfferById(id)

    override fun findOfferByCreatedBefore(created: Date) = offerRepository.findOfferByCreatedBefore(created)

    override fun findOffersByUniversity(university: University) = offerRepository.findOffersByUniversity(university)

    override fun findOffersByUser(user: User) = offerRepository.findOffersByUser(user)
}
