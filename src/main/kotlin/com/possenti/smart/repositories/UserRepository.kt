package com.possenti.smart.repositories

import com.possenti.smart.documents.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {

    fun findByEmail(email: String): User?

}