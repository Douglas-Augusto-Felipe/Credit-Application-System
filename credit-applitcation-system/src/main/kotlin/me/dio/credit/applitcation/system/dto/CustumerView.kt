package me.dio.credit.applitcation.system.dto

import me.dio.credit.applitcation.system.entity.Custumer
import java.math.BigDecimal

data class CustumerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String
) {
    constructor(custumer: Custumer) : this(
        firstName = custumer.firstname,
        lastName = custumer.lastname,
        cpf = custumer.cpf,
        income = custumer.income,
        email = custumer.email,
        zipCode = custumer.address.zipcode,
        street = custumer.address.street
    )
}
