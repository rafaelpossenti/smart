package com.possenti.smart.services.impl

import com.possenti.smart.documents.User
import com.possenti.smart.repositories.UserRepository
import com.possenti.smart.services.UserService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        val userRepository: UserRepository
) : UserService {

    val LOGGER = LoggerFactory.getLogger(UserServiceImpl::class.java)

    override fun save(user: User): User {
        LOGGER.info("saving a new user")
        user.password = BCryptPasswordEncoder().encode(user.password)
        return userRepository.save(user)
    }

    override fun update(id: String, user: User): User {

        LOGGER.info("updating a user with id: $id")

        val userDb = userRepository.findById(id).orElse(null) ?: throw IllegalArgumentException("Usuário não encontrado")

        if (user.password != null) {
            userDb.password = BCryptPasswordEncoder().encode(user.password)
        }
        if (user.name != null) userDb.name = user.name

        return userRepository.save(userDb)
    }

    override fun findByEmail(email: String) = userRepository.findByEmail(email)

    override fun findById(id: String) = userRepository.findById(id).orElse(null)

    override fun findAll(pageRequest: PageRequest): Page<User> {
        LOGGER.info("getting all users")
        return userRepository.findAll(pageRequest)
    }
}