package me.dio.credit.applitcation.system.service.impl

import me.dio.credit.applitcation.system.entity.Custumer
import me.dio.credit.applitcation.system.exception.BusinessException
import me.dio.credit.applitcation.system.reporsitory.CustumerRepository
import me.dio.credit.applitcation.system.service.ICustumerService
import org.springframework.stereotype.Service

@Service
class CustumerService(
    private val custumerRepository: CustumerRepository
) : ICustumerService {
    override fun save(custumer: Custumer): Custumer =
        this.custumerRepository.save(custumer)


    override fun findById(id: Long): Custumer =
        this.custumerRepository.findById(id).orElseThrow {
            throw BusinessException("Id $id not found")
        }


    override fun delete(id: Long) {
        val custumer: Custumer = this.findById(id)
        this.custumerRepository.delete(custumer)
    }
}