package com.possenti.smart.dtos

data class EmpresaDto(
        val razaoSocial: String,
        val cnpj: String,
        val id: String? = null
)