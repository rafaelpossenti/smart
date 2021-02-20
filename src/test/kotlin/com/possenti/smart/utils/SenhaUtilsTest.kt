package com.possenti.smart.utils

import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.util.Assert

private const val SENHA = "123456"

class SenhaUtilsTest {

    private val bCryptEncoder = BCryptPasswordEncoder()

    @Test
    fun  `testa se o hash informado pertence a senha informada`() {
        val hash = SenhaUtils().gerarBCrypt(SENHA)
        Assert.isTrue(bCryptEncoder.matches(SENHA, hash), "Hash informado não pertence com a senha informada.")
    }
}