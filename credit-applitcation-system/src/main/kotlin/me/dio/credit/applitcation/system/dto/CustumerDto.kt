package me.dio.credit.applitcation.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.applitcation.system.entity.Address
import me.dio.credit.applitcation.system.entity.Custumer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustumerDto(
    @field:NotEmpty(message = "Invalid input")val firstName: String,
    @field:NotEmpty(message = "Invalid input")val lastName: String,
    @field:NotEmpty(message = "Invalid input")
    @field:CPF(message = "This invalid CPF")
    val cpf: String,
    @field:NotNull(message = "Invalid input")val income: BigDecimal,
    @field:Email(message = "Invalid Email")
    @field:NotEmpty(message = "Invalid input")val email: String,
    @field:NotEmpty(message = "Invalid input")val password: String,
    @field:NotEmpty(message = "Invalid input")val zipCode: String,
    @field:NotEmpty(message = "Invalid input")val street: String
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
