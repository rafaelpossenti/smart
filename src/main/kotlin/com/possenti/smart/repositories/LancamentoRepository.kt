package com.possenti.smart.repositories

import com.possenti.smart.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.mongodb.repository.MongoRepository
import java.awt.print.Pageable

interface LancamentoRepository : MongoRepository<Lancamento, String> {

    fun findByFuncionarioId(funcionarioId: String, pageable: Pageable): Page<Lancamento>
}