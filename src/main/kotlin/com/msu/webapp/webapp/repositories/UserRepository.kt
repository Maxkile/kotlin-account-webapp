package com.msu.webapp.webapp.repositories

import com.msu.webapp.webapp.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User,Int>{
    fun findUserById(id: Int): User
    fun findUserByUsername(username: String): User
}