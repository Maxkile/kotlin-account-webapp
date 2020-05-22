package com.msu.webapp.webapp.services.security

import com.msu.webapp.webapp.services.user.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SecurityServiceImpl(

        private val securityLogger: Logger = LoggerFactory.getLogger(SecurityServiceImpl::class.java),

        @Autowired
        private val authenticationManager: AuthenticationManager,

        @Autowired
        private val userService: UserService,

        @Autowired
        private val bCryptPasswordEncoder: PasswordEncoder
): SecurityService{
    override fun autoLogin(userName: String?, userPassword: String?, authorities: Collection<GrantedAuthority>) {
        try{
            val token: UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userName,userPassword,authorities)
            val authentication: Authentication? = authenticationManager.authenticate(token)
            SecurityContextHolder.getContext().authentication = authentication
        } catch (exc: AuthenticationException){
            SecurityContextHolder.getContext().authentication = null
            securityLogger.warn("User $userName not authenticated!")
        }
    }
}
