package com.possenti.smart.services.impl

import com.possenti.smart.documents.User
import com.possenti.smart.dto.user.UserSaveDto
import com.possenti.smart.dto.user.UserUpdateDto
import com.possenti.smart.exception.UserNotFoundException
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

    override fun save(dto: UserSaveDto): User {
        LOGGER.info("saving a new user")
        val user = convertUserSaveDtoToUser(dto)
        user.password = BCryptPasswordEncoder().encode(user.password)
        return userRepository.save(user)
    }

    override fun update(id: String, dto: UserUpdateDto): User {

        LOGGER.info("updating a user with id: $id")

        val userDb = userRepository.findById(id).orElse(null) ?: throw IllegalArgumentException("Usuário não encontrado")

        if (dto.password != null) {
            userDb.password = BCryptPasswordEncoder().encode(dto.password)
        }
        if (dto.name != null) userDb.name = dto.name

        return userRepository.save(userDb)
    }

    override fun delete(id: String) {
        this.findById(id)
        userRepository.deleteById(id)
    }

    override fun findByEmail(email: String) = userRepository.findByEmail(email)

    override fun findById(id: String) = userRepository.findById(id).orElseThrow { UserNotFoundException() }

    override fun findAll(pageRequest: PageRequest): Page<User> {
        LOGGER.info("getting all users")
        return userRepository.findAll(pageRequest)
    }

    private fun convertUserSaveDtoToUser(user: UserSaveDto) =
            User(user.name, user.email, user.password, user.perfil, null)
}