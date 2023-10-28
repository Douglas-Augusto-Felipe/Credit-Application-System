package me.dio.credit.applitcation.system.reporsitory

import me.dio.credit.applitcation.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CreditRepository: JpaRepository<Credit,Long>{
    fun findByCreditCode(creditCode: UUID): Credit?
}