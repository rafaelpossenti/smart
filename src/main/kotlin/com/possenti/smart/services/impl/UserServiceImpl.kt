package com.possenti.smart.services.impl

import com.possenti.smart.documents.User
import com.possenti.smart.repositories.UserRepository
import com.possenti.smart.services.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {

    override fun save(user: User) = userRepository.save(user)

    override fun findByEmail(email: String) = userRepository.findByEmail(email)

    override fun findById(id: String) = userRepository.findById(id).orElse(null)
}