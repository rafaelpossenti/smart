package com.possenti.smart.services.impl

import com.possenti.smart.documents.Lancamento
import com.possenti.smart.repositories.LancamentoRepository
import com.possenti.smart.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {
    override fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento> {
        TODO("Not yet implemented")
    }

    override fun buscarPorId(id: String): Lancamento? {
        TODO("Not yet implemented")
    }

    override fun persistir(lancamento: Lancamento): Lancamento {
        TODO("Not yet implemented")
    }

    override fun remover(id: String) {
        TODO("Not yet implemented")
    }
}