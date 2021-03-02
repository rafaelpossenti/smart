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
class SmartApplication(val empresaRepository: EmpresaRepository,
					   val funcionarioRepository: FuncionarioRepository) : CommandLineRunner {

	override fun run(vararg args: String?) {
		empresaRepository.deleteAll()
		funcionarioRepository.deleteAll()

		val empresa = Empresa("Empresa", "61957438000157")
		empresaRepository.save(empresa)
		val empresaDb = empresaRepository.findByCnpj("61957438000157")

		val admin = Funcionario("Admin", "admin@empresa.com",
				SenhaUtils().gerarBCrypt("123456"), "44579798058",
				PerfilEnum.ROLE_ADMIN, empresaDb?.id!!)
		funcionarioRepository.save(admin)

		val funcionario = Funcionario("Funcionario", "funcionario@empresa.com",
				SenhaUtils().gerarBCrypt("123456"), "86802539012",
				PerfilEnum.ROLE_USUARIO, empresaDb.id)
		funcionarioRepository.save(funcionario)

		println("empresa id:  ${empresaDb.id} ")

	}

}

fun main(args: Array<String>) {
	runApplication<SmartApplication>(*args)
}
