package com.possenti.smart.dto.user

import com.possenti.smart.enums.PerfilEnum
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class UserSaveDto(

        @get:NotEmpty(message = "Nome não pode ser vazio.")
        @get:Length(min = 3, max = 30, message = "Nome deve conter entre 3  e 30 caracteres.")
        var name: String? = null,

        @get:NotEmpty(message = "Email não pode ser vazio.")
        @get:Length(min = 5, max = 200, message = "Email deve conter entre 5  e 200 caracteres.")
        @get:Email(message = "Email inválido.")
        val email: String,

        @get:NotEmpty(message = "Password não pode ser vazio.")
        @get:Length(min = 5, max = 30, message = "Password deve conter entre 5  e 30 caracteres.")
        var password: String? = null,

        val perfil: PerfilEnum,
)
