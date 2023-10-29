package me.dio.credit.applitcation.system.service.impl

import me.dio.credit.applitcation.system.entity.Credit
import me.dio.credit.applitcation.system.exception.BusinessException
import me.dio.credit.applitcation.system.reporsitory.CreditRepository
import me.dio.credit.applitcation.system.service.ICreditService
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val custumerService: CustumerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        this.validDayFirstInstallment(credit.dayFirstInstallment)
        credit.apply { custumer = custumerService.findById(credit.custumer?.id!!) }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustumer(custumerId: Long): List<Credit> =
        this.creditRepository.findAllByCustumer(custumerId)

    override fun findByCreditCode(custumerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("Creditcode $creditCode not found"))
        return if (credit.custumer?.id == custumerId)
            credit else throw IllegalArgumentException("Contact admin")
    }

    private fun validDayFirstInstallment(dayFirstInstallment: LocalDate): Boolean {
        return if (dayFirstInstallment.isBefore(LocalDate.now().plusMonths(3))) true
        else throw BusinessException("Invalid Date")
    }
}