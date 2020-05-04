package com.msu.webapp.webapp.services.user

import com.msu.webapp.webapp.models.User

interface UserService {
    fun save(user: User): Unit
    fun delete(user: User): Unit
    fun findUserById(id: Int): User
    fun findUserByUsername(username: String): User
}