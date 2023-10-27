package me.dio.credit.applitcation.system.service

import me.dio.credit.applitcation.system.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustumer(custumerId: Long): List<Credit>
    fun findByCreditCode(creditCode:UUID): Credit
}