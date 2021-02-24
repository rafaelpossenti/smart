package com.possenti.smart.services

import com.possenti.smart.documents.Empresa
import com.possenti.smart.repositories.EmpresaRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.event.annotation.BeforeTestClass
import kotlin.jvm.Throws

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmpresaServiceTest {

    @Autowired
    private val empresaService: EmpresaService? = null

    @MockBean
    private val empresaRepository: EmpresaRepository? = null

    private val CNPJ = "23690176000118"

    @BeforeTestClass
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(empresaRepository?.findByCnpj(CNPJ)).willReturn(empresa())
        BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
    }

    @Test
    fun `testa se a busca de empresa por cnpj nao retorna null quando existir valor`() {
        val empresa: Empresa? = empresaService?.buscarPorCnpj(CNPJ)
        Assertions.assertNotNull(empresa)
    }

    @Test
    fun `testa se ao salvar uma empresa nao retorna null`() {
        val empresa: Empresa? = empresaService?.persistir(empresa())
        Assertions.assertNotNull(empresa)
    }

    private fun empresa() = Empresa("Razão social", CNPJ, "1")

}