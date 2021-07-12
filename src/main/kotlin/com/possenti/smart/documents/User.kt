package com.possenti.smart.documents

import com.possenti.smart.enums.PerfilEnum
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
        var name: String? = null,
        val email: String,
        var password: String? = null,
        val perfil: PerfilEnum,
        var image: String? = null
)