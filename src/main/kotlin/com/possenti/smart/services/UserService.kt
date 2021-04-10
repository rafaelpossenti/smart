package com.possenti.smart.services

import com.possenti.smart.documents.User
import com.possenti.smart.dto.user.UserSaveDto
import com.possenti.smart.dto.user.UserUpdateDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.multipart.MultipartFile

interface UserService {

    fun save(user: UserSaveDto): User

    fun update(id: String, user: UserUpdateDto): User

    fun delete(id: String)

    fun findByEmail(email: String): User?

    fun findById(id: String): User?

    fun findAll(pageRequest: PageRequest) : Page<User>

    fun saveImage(id: String, file: MultipartFile)
}