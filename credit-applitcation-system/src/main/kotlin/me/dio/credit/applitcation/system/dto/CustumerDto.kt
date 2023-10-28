package me.dio.credit.applitcation.system.dto

import me.dio.credit.applitcation.system.entity.Address
import me.dio.credit.applitcation.system.entity.Custumer
import java.math.BigDecimal

data class CustumerDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String
) {

    fun toEntity(): Custumer = Custumer(
        firstname = this.firstName,
        lastname = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.password,
        address = Address(
            zipcode=this.zipCode,
            street = this.street
        )
    )
}
