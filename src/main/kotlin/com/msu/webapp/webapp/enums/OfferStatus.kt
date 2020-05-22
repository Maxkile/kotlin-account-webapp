package com.msu.webapp.webapp.enums

import org.springframework.security.core.GrantedAuthority

enum class OfferStatus(private val str: String): GrantedAuthority {
    CREATED("created"),
    CONSIDERING("considering"),
    APPROVED("approved"),
    REJECTED("rejected");

    override fun getAuthority() =  str
}