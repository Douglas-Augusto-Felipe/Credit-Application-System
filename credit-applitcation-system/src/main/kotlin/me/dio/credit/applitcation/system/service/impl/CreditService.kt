package me.dio.credit.applitcation.system.service.impl

import me.dio.credit.applitcation.system.entity.Credit
import me.dio.credit.applitcation.system.reporsitory.CreditRepository
import me.dio.credit.applitcation.system.service.ICreditService
import java.lang.RuntimeException
import java.util.*

class CreditService(
    private val creditRepository: CreditRepository, private val custumerService: CustumerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply { custumer = custumerService.findById(credit.custumer?.id!!) }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustumer(custumerId: Long): List<Credit> =
        this.creditRepository.findAllByCustumer(custumerId)

    override fun findByCreditCode(custumerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Creditcode $creditCode not found"))
        return  if(credit.custumer?.id == custumerId)
            credit else throw  RuntimeException("Contact admin")
    }
}