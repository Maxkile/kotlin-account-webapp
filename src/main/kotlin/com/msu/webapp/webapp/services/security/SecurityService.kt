package com.msu.webapp.webapp.services.security

import org.springframework.security.core.GrantedAuthority

interface SecurityService{
    fun autoLogin(userName: String?,userPassword: String?,authorities: Collection<GrantedAuthority>)
}