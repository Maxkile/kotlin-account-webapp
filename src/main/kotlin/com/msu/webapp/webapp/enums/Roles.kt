package com.msu.webapp.webapp.enums

import org.springframework.security.core.GrantedAuthority

enum class Roles(private val str: String): GrantedAuthority {
    USER("user"),
    ADMIN("admin");

    override fun getAuthority() =  str
}