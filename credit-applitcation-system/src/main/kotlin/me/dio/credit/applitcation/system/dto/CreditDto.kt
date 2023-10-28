package me.dio.credit.applitcation.system.dto

import me.dio.credit.applitcation.system.entity.Credit
import me.dio.credit.applitcation.system.entity.Custumer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallment: Int,
    val custumerId: Long
) {
    fun toEntity(): Credit = Credit(

        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallment = this.numberOfInstallment,
        custumer = Custumer(id = this.custumerId)

    )
}
