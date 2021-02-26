package com.possenti.smart.services

import com.possenti.smart.documents.Lancamento
import com.possenti.smart.enums.TipoEnum
import com.possenti.smart.repositories.LancamentoRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import java.util.*
import kotlin.collections.ArrayList
import kotlin.jvm.Throws

@SpringBootTest
class LancamentoServiceTest {

    @MockBean
    private val lancamentoRepository: LancamentoRepository? = null

    @Autowired
    private val lancamentoService: LancamentoService? = null

    private val id: String = "1"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito
                .given<Page<Lancamento>>(lancamentoRepository?.findByFuncionarioId(id, PageRequest.of(0, 10)))
                .willReturn(PageImpl(ArrayList<Lancamento>()))
        BDDMockito.given(lancamentoRepository?.findById(id)).willReturn(Optional.of(lancamento()))
        BDDMockito.given(lancamentoRepository?.save(Mockito.any(Lancamento::class.java)))
                .willReturn(lancamento())

    }

    @Test
    fun `testa se ao salvar lancamento nao retorna null`() {
        val lancamento: Lancamento? = lancamentoService?.persistir(lancamento())
        Assertions.assertNotNull(lancamento)
    }

    @Test
    fun `testa se a busca de lancamento funcionarioId nao retorna null quando existir valor`() {
        val lancamento: Page<Lancamento>? = lancamentoService?.buscarPorFuncionarioId(id, PageRequest.of(0, 10))
        Assertions.assertNotNull(lancamento)
    }

    @Test
    fun `testa se a busca de lancamento por id nao retorna null quando existir valor`() {
        val lancamento: Lancamento? = lancamentoService?.buscarPorId(id)
        Assertions.assertNotNull(lancamento)
    }

    private fun lancamento() = Lancamento(Date(), TipoEnum.INICIO_TRABALHO, id)
}