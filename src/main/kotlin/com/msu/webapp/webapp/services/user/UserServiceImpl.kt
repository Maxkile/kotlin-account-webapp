package com.msu.webapp.webapp.services.user

import com.msu.webapp.webapp.models.User
import com.msu.webapp.webapp.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserServiceImpl(
        @Autowired
        private val userRepository: UserRepository,

        @Autowired
        private val bCryptPasswordEncoder: PasswordEncoder

): UserService {

    override fun save(user: User) {
        user.password = bCryptPasswordEncoder.encode(user.password)
        userRepository.save(user)
    }

    override fun delete(user: User) {
        userRepository.delete(user)
    }

    override fun findUserById(id: Int) = userRepository.findUserById(id)

    override fun findUserByUsername(username: String) = userRepository.findUserByUsername(username)
}