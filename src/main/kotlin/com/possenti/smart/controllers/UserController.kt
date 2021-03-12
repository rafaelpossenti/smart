package com.possenti.smart.controllers

import com.possenti.smart.documents.Lancamento
import com.possenti.smart.documents.User
import com.possenti.smart.dtos.LancamentoDto
import com.possenti.smart.dtos.UserDto
import com.possenti.smart.response.Response
import com.possenti.smart.services.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/smart/users")
class UserController(val userServce: UserService) {

    @Value("\${paginacao.qtd_por_pagina}")
    val qtdPorPagina: Int = 15

    @PostMapping
    fun save(@Valid @RequestBody user: User,
                  result: BindingResult): ResponseEntity<Response<User>> {
        val response: Response<User> = Response()

        userServce.save(user)
        response.data = user

        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun get(@RequestParam(value = "pag", defaultValue = "0") pag: Int,
            @RequestParam(value = "ord", defaultValue = "id") ord: String,
            @RequestParam(value = "dir", defaultValue = "DESC") dir: String):
            ResponseEntity<Response<Page<UserDto>>> {

        val response: Response<Page<UserDto>> = Response()

        val pageRequest: PageRequest = PageRequest.of(pag, qtdPorPagina, Sort.Direction.valueOf(dir), ord)
        val users = userServce.findAll(pageRequest)

        val usersDto: Page<UserDto> =
                users.map { lancamento -> convertUserDto(lancamento) }

        response.data = usersDto
        return ResponseEntity.ok(response)
    }

    private fun convertUserDto(user: User) =
            UserDto(user.email, user.name, user.perfil, user.id)

}