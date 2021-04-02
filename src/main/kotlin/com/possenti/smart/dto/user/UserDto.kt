package com.possenti.smart.dto.user

import com.possenti.smart.enums.PerfilEnum

data class UserDto(
        val email: String,
        val name: String? = null,
        val perfil: PerfilEnum,
        var id: String? = null
)