package me.dio.credit.applitcation.system.reporsitory


import me.dio.credit.applitcation.system.entity.Custumer
import org.springframework.data.jpa.repository.JpaRepository

interface CustumerRepository: JpaRepository<Custumer, Long>