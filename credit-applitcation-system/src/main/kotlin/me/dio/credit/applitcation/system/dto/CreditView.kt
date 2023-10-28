package me.dio.credit.applitcation.system.dto

import me.dio.credit.applitcation.system.entity.Credit
import me.dio.credit.applitcation.system.enummeration.Status
import java.math.BigDecimal
import java.util.UUID

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallment: Int,
    val status: Status,
    val emailCustumer: String?,
    val incomeCustumer: BigDecimal?
) {
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallment,
        status = credit.status,
        emailCustumer = credit.custumer?.email,
        incomeCustumer = credit.custumer?.income
    )
}
