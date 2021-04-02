package com.possenti.smart.dto

data class EmpresaDto(
        val razaoSocial: String,
        val cnpj: String,
        val id: String? = null
)