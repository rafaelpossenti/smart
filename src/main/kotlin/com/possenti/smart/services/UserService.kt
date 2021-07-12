package com.possenti.smart.services

import com.possenti.smart.documents.User
import com.possenti.smart.dto.user.UserSaveDto
import com.possenti.smart.dto.user.UserUpdateDto
import com.possenti.smart.exception.UserNotFoundException
import com.possenti.smart.repositories.UserRepository
import com.possenti.smart.utils.FileSaver
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UserService(
        val userRepository: UserRepository,
        val fileSaver: FileSaver
) {

    val LOGGER = LoggerFactory.getLogger(UserService::class.java)

    fun save(dto: UserSaveDto): User {
        LOGGER.info("saving a new user")
        val user = convertUserSaveDtoToUser(dto)
        user.password = BCryptPasswordEncoder().encode(user.password)
        return userRepository.save(user)
    }

    fun update(email: String, dto: UserUpdateDto): User {

        LOGGER.info("updating a user with email: $email")

        val userDb = this.findByEmail(email)

        if (dto.password != null) {
            userDb.password = BCryptPasswordEncoder().encode(dto.password)
        }
        if (dto.name != null) userDb.name = dto.name

        return userRepository.save(userDb)
    }

    fun delete(id: String) {
        this.findByEmail(id)
        userRepository.deleteById(id)
    }

    fun findByEmail(email: String) = userRepository.findByEmail(email) ?: throw UserNotFoundException()

    fun findAll(pageRequest: PageRequest): Page<User> {
        LOGGER.info("getting all users")
        return userRepository.findAll(pageRequest)
    }

    fun saveImage(id: String, file: MultipartFile) {
        val user = this.findByEmail(id)
        val s3Object = fileSaver.write(file)
        user.image = s3Object
        userRepository.save(user)
    }

    private fun convertUserSaveDtoToUser(user: UserSaveDto) =
            User(user.name, user.email, user.password, user.perfil, null)
}