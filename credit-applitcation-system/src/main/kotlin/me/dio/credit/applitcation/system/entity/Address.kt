package me.dio.credit.applitcation.system.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class Address(
    @Column(nullable = false)
    var zipcode: String = "",

    @Column(nullable = false)
    var street: String = ""
)
