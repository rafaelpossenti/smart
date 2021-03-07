package com.possenti.smart

import com.possenti.smart.documents.Empresa
import com.possenti.smart.documents.Funcionario
import com.possenti.smart.enums.PerfilEnum
import com.possenti.smart.repositories.EmpresaRepository
import com.possenti.smart.repositories.FuncionarioRepository
import com.possenti.smart.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmartApplication

fun main(args: Array<String>) {
	runApplication<SmartApplication>(*args)
}
