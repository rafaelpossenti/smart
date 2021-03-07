package com.possenti.smart.documents

import com.possenti.smart.enums.PerfilEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User (
        val name: String,
        val email: String,
        val password: String,
        val perfil: PerfilEnum,
        @Id val id: String? = null
)