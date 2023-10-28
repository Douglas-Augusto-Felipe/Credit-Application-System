package me.dio.credit.applitcation.system.dto

import me.dio.credit.applitcation.system.entity.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberAllInstallments: Int
) {
    constructor(credit: Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberAllInstallments = credit.numberOfInstallment

    )

}
