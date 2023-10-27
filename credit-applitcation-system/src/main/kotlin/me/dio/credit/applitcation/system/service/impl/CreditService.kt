package me.dio.credit.applitcation.system.service.impl

import me.dio.credit.applitcation.system.entity.Credit
import me.dio.credit.applitcation.system.reporsitory.CreditRepository
import me.dio.credit.applitcation.system.service.ICreditService
import java.util.*

class CreditService(
    private  val creditRepository: CreditRepository
    private val custumerService: CustumerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply { custumer=custumerService.findById(credit.custumer?.id!!) }
       return this.creditRepository.save(credit)
    }

    override fun findAllByCustumer(custumerId: Long): List<Credit> {
        TODO("Not yet implemented")
    }

    override fun findByCreditCode(creditCode: UUID): Credit {
        TODO("Not yet implemented")
    }
}