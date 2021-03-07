package com.possenti.smart.controllers

import com.possenti.smart.documents.User
import com.possenti.smart.response.Response
import com.possenti.smart.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/smart/users")
class UserController(val userServce: UserService) {

    @PostMapping
    fun save(@Valid @RequestBody user: User,
                  result: BindingResult): ResponseEntity<Response<User>> {
        val response: Response<User> = Response<User>()

        userServce.save(user)
        response.data = user

        return ResponseEntity.ok(response)
    }



}