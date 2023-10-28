package me.dio.credit.applitcation.system.dto

import me.dio.credit.applitcation.system.entity.Custumer
import java.math.BigDecimal

data class CustumerUpdateDto(
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {
    fun toEntity(custumer: Custumer): Custumer{
        custumer.firstname = this.firstName
        custumer.lastname = this.lastName
        custumer.income = this.income
        custumer.address.zipcode = this.zipCode
        custumer.address.street = this.street
        return custumer
    }
}
