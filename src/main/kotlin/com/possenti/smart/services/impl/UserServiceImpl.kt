package com.possenti.smart.services.impl

import com.possenti.smart.documents.User
import com.possenti.smart.repositories.UserRepository
import com.possenti.smart.services.UserService
import org.springframework.data.domain.PageRequest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {

    override fun save(user: User): User {
        user.password = BCryptPasswordEncoder().encode(user.password)
        return userRepository.save(user)
    }

    override fun update(id: String, user: User): User {

        val userDb = userRepository.findById(id).orElse(null) ?: throw IllegalArgumentException("Usuário não encontrado")

        if (user.password != null) {
            userDb.password = BCryptPasswordEncoder().encode(user.password)
        }
        if (user.name != null) userDb.name = user.name

        return userRepository.save(userDb)
    }

    override fun findByEmail(email: String) = userRepository.findByEmail(email)

    override fun findById(id: String) = userRepository.findById(id).orElse(null)

    override fun findAll(pageRequest: PageRequest) = userRepository.findAll(pageRequest)

}