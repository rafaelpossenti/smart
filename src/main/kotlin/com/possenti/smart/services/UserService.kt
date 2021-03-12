package com.possenti.smart.services

import com.possenti.smart.documents.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface UserService {

    fun save(user: User): User

    fun update(id: String, user: User): User

    fun findByEmail(email: String): User?

    fun findById(id: String): User?

    fun findAll(pageRequest: PageRequest) : Page<User>
}