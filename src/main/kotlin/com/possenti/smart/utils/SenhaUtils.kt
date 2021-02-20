package com.possenti.smart.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtils {

    fun gerarBCrypt(senha: String) = BCryptPasswordEncoder().encode(senha)
}