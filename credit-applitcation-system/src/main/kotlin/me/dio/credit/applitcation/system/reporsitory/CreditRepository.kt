package me.dio.credit.applitcation.system.reporsitory

import me.dio.credit.applitcation.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface CreditRepository: JpaRepository<Credit,Long>{
    fun findByCreditCode(creditCode: UUID): Credit?
    @Query(value = "SELECT * FROM CREDIT WHERE CREDIT_ID = ?1", nativeQuery = true)
    fun findAllByCustumer(custumerId: Long): List<Credit>
}