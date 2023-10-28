package me.dio.credit.applitcation.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.credit.applitcation.system.entity.Credit
import me.dio.credit.applitcation.system.entity.Custumer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid input") val creditValue: BigDecimal,
    @field:Future val dayFirstOfInstallment: LocalDate,
    val numberOfInstallment: Int,
    @field:NotNull(message = "Invalid input")val custumerId: Long
) {
    fun toEntity(): Credit = Credit(

        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallment = this.numberOfInstallment,
        custumer = Custumer(id = this.custumerId)

    )
}
