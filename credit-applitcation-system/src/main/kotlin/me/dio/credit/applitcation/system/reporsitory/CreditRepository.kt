package me.dio.credit.applitcation.system.reporsitory

import me.dio.credit.applitcation.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository

interface CreditRepository: JpaRepository<Credit,Long>