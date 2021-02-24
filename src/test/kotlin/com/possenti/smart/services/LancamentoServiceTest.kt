package com.possenti.smart.services

import com.possenti.smart.documents.Funcionario
import com.possenti.smart.enums.PerfilEnum
import com.possenti.smart.repositories.FuncionarioRepository
import com.possenti.smart.utils.SenhaUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*
import kotlin.jvm.Throws

@SpringBootTest
class LancamentoServiceTest {

// TODO: change here
//    @MockBean
//    private val funcionarioRepository: FuncionarioRepository? = null
//
//    @Autowired
//    private val funcionarioService: FuncionarioService? = null
//
//    private val email: String = "email@email.com"
//    private val cpf: String = "24397069069"
//    private val id: String = "1"
//
//    @BeforeEach
//    @Throws(Exception::class)
//    fun setUp() {
//        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java)))
//                .willReturn(funcionario())
//        BDDMockito.given(funcionarioRepository?.findById(id)).willReturn(Optional.of(funcionario()))
//        BDDMockito.given(funcionarioRepository?.findByEmail(email)).willReturn(funcionario())
//        BDDMockito.given(funcionarioRepository?.findByCpf(cpf)).willReturn(funcionario())
//
//    }
//
//    @Test
//    fun `testa se ao salvar funcionario nao retorna null`() {
//        val funcionario: Funcionario? = funcionarioService?.persistir(funcionario())
//        Assertions.assertNotNull(funcionario)
//    }
//
//    @Test
//    fun `testa se a busca de funcionario por cpf nao retorna null quando existir valor`() {
//        val funcionario: Funcionario? = funcionarioService?.buscarPorCpf(cpf)
//        Assertions.assertNotNull(funcionario)
//    }
//
//    @Test
//    fun `testa se a busca de funcionario por email nao retorna null quando existir valor`() {
//        val funcionario: Funcionario? = funcionarioService?.buscarPorEmail(email)
//        Assertions.assertNotNull(funcionario)
//    }
//
//    @Test
//    fun `testa se a busca de funcionario por id nao retorna null quando existir valor`() {
//        val funcionario: Funcionario? = funcionarioService?.buscarPorId(id)
//        Assertions.assertNotNull(funcionario)
//    }
//
//    private fun funcionario() =
//            Funcionario("Nome", email, SenhaUtils().gerarBCrypt("123456"),
//            cpf, PerfilEnum.ROLE_USUARIO, id)
}