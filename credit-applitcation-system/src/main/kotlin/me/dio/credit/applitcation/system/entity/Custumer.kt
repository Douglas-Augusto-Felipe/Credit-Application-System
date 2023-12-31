package me.dio.credit.applitcation.system.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table
data class Custumer(

    @Column(nullable = false)
    var firstname: String = "",

    @Column(nullable = false)
    var lastname: String = "",

    @Column(nullable = false, unique = true)
    var cpf: String = "",

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    var income: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = false)
    @Embedded
    var address: Address = Address(),

    @Column(nullable = false) @OneToMany(
        fetch = FetchType.LAZY,
        cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),
     mappedBy = "custumer")
    var credits: List<Credit> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
