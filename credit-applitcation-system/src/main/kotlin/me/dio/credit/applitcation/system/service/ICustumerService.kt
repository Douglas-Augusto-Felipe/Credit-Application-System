package me.dio.credit.applitcation.system.service

import me.dio.credit.applitcation.system.entity.Custumer

interface ICustumerService {
    fun save(custumer: Custumer): Custumer
    fun findById(id: Long): Custumer
    fun delete(id: Long)
}