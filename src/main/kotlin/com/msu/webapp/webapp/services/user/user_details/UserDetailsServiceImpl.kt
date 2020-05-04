package com.msu.webapp.webapp.services.user.user_details

import com.msu.webapp.webapp.services.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
        @Autowired
        private val userService: UserService

): CustomUserDetailsService{
    override fun loadUserByUsername(username: String) = userService.findUserByUsername(username)
}