package com.possenti.smart.dtos

import javax.validation.constraints.NotEmpty

data class LancamentoDto(
     @get:NotEmpty (message = "Data não pode ser vazia.")
     val data: String? = null,

     @get:NotEmpty (message = "Nome não pode ser vazio.")
     val tipo: String? = null,

     val descricao: String? = null,
     val localizacao: String? = null,
     val funcionarioId: String? = null,
     val id: String? = null
)