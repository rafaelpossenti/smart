package com.possenti.smart.controller

import com.possenti.smart.documents.User
import com.possenti.smart.dto.user.UserDto
import com.possenti.smart.dto.user.UserSaveDto
import com.possenti.smart.dto.user.UserUpdateDto
import com.possenti.smart.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    @PostMapping
    fun insert(@Valid @RequestBody user: UserSaveDto): ResponseEntity<User> {
        val userDb = userService.save(user)
        return ResponseEntity.ok(userDb)
    }

    @PutMapping("/{email}")
    fun update(@PathVariable("email") email: String,
               @Valid @RequestBody user: UserUpdateDto): ResponseEntity<User> { //DTO
        val userDb = userService.update(email, user)
        return ResponseEntity.ok(userDb)
    }

    @DeleteMapping("/{email}")
    fun delete(@PathVariable("email") email: String): ResponseEntity<User> {
        userService.delete(email)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{email}")
    fun findById(@PathVariable("email") email: String): ResponseEntity<UserDto> {
        val user = userService.findByEmail(email)
        return ResponseEntity.ok(convertUserDto(user!!))
    }

    @GetMapping
    fun findAll(pageable: Pageable):
            ResponseEntity<Page<UserDto>> {

        val users = userService.findAll(pageable)

        val usersDto = users.map { user -> convertUserDto(user) }

        return ResponseEntity.ok(usersDto)
    }

    @PostMapping("/{email}/image")
    fun saveImage(@PathVariable("email") email: String,
                  @RequestParam("file") file: MultipartFile) {
        userService.saveImage(email, file)
    }

    private fun convertUserDto(user: User) =
            UserDto(user.email, user.name, user.perfil, user.image)

}