package com.possenti.smart.dto.user

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

data class UserUpdateDto (

    @get:NotEmpty(message = "Nome não pode ser vazio.")
    @get:Length(min = 3, max = 30, message = "Nome deve conter entre 3  e 30 caracteres.")
    var name: String? = null,

    @get:NotEmpty(message = "Password não pode ser vazio.")
    @get:Length(min = 5, max = 30, message = "Password deve conter entre 5  e 30 caracteres.")
    var password: String? = null,
)