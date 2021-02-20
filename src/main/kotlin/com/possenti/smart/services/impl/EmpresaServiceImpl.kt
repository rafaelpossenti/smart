package com.possenti.smart.services.impl

import com.possenti.smart.documents.Empresa
import com.possenti.smart.repositories.EmpresaRepository
import com.possenti.smart.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String) = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa) = empresaRepository.save(empresa)
}