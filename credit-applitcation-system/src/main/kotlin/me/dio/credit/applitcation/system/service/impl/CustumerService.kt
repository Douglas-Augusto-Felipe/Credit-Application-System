package me.dio.credit.applitcation.system.service.impl

import me.dio.credit.applitcation.system.entity.Custumer
import me.dio.credit.applitcation.system.exception.BusinessException
import me.dio.credit.applitcation.system.reporsitory.CustumerRepository
import me.dio.credit.applitcation.system.service.ICustumerService
import java.lang.RuntimeException

class CustumerService(
    private val custumerRepository: CustumerRepository
): ICustumerService {
    override fun save(custumer: Custumer): Custumer =
        this.custumerRepository.save(custumer)


    override fun findById(id: Long): Custumer =
        this.custumerRepository.findById(id).orElseThrow{
            throw BusinessException("Id $id not found")
        }

    override fun delete(id: Long) =
        this.custumerRepository.deleteById(id)
}