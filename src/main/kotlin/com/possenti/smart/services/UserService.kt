package com.possenti.smart.services

import com.possenti.smart.documents.User

interface UserService {

    fun save(funcionario: User): User

    fun findByEmail(email: String): User?

    fun findById(id: String): User?

}