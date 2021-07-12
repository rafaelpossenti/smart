package com.possenti.smart.controllers

import com.possenti.smart.documents.User
import com.possenti.smart.dto.user.UserDto
import com.possenti.smart.dto.user.UserSaveDto
import com.possenti.smart.dto.user.UserUpdateDto
import com.possenti.smart.services.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @Value("\${paginacao.qtd_por_pagina}")
    val qtdPorPagina: Int = 15

    @GetMapping("/status/check")
    fun status() = "working"

    @PostMapping
    fun insert(@Valid @RequestBody user: UserSaveDto): ResponseEntity<User> {

        val userDb = userService.save(user)

        return ResponseEntity.ok(userDb)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String,
               @Valid @RequestBody user: UserUpdateDto): ResponseEntity<User> { //DTO

        val userDb = userService.update(id, user)

        return ResponseEntity.ok(userDb)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String): ResponseEntity<User> {
        userService.delete(id)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{email}")
    fun findById(@PathVariable("email") email: String): ResponseEntity<UserDto> {
        val user = userService.findByEmail(email)
        return ResponseEntity.ok(convertUserDto(user!!))
    }

    @GetMapping
    fun findAll(@RequestParam(value = "pag", defaultValue = "0") pag: Int,
                @RequestParam(value = "ord", defaultValue = "id") ord: String,
                @RequestParam(value = "dir", defaultValue = "DESC") dir: String):
            ResponseEntity<Page<UserDto>> {

        val pageRequest: PageRequest = PageRequest.of(pag, qtdPorPagina, Sort.Direction.valueOf(dir), ord)
        val users = userService.findAll(pageRequest)

        val usersDto: Page<UserDto> =
                users.map { user -> convertUserDto(user) }

        return ResponseEntity.ok(usersDto)
    }

    @GetMapping("/{id}/exists")
    fun exists(@RequestHeader("x-user-email") userEmail: String) : ResponseEntity<Boolean> {
        val exists = userService.findByEmail(userEmail) != null
        return ResponseEntity.ok(exists)
    }

    @PostMapping("/{id}/image")
    fun saveImage(@PathVariable("id") id: String,
                  @RequestParam("file") file: MultipartFile) {
        userService.saveImage(id, file)
    }

    private fun convertUserDto(user: User) =
            UserDto(user.email, user.name, user.perfil, user.image)

}