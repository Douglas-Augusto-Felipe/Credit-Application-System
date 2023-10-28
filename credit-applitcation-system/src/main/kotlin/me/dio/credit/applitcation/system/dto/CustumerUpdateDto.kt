package me.dio.credit.applitcation.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.applitcation.system.entity.Custumer
import java.math.BigDecimal

data class CustumerUpdateDto(
    @field:NotEmpty(message = "Invalid input") val firstName: String,
    @field:NotEmpty(message = "Invalid input") val lastName: String,
    @field:NotNull(message = "Invalid input") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid input") val zipCode: String,
    @field:NotEmpty(message = "Invalid input") val street: String
) {
    fun toEntity(custumer: Custumer): Custumer {
        custumer.firstname = this.firstName
        custumer.lastname = this.lastName
        custumer.income = this.income
        custumer.address.zipcode = this.zipCode
        custumer.address.street = this.street
        return custumer
    }
}
