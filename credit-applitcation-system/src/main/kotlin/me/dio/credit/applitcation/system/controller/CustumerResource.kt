package me.dio.credit.applitcation.system.controller

import me.dio.credit.applitcation.system.dto.CustumerDto
import me.dio.credit.applitcation.system.service.impl.CustumerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/custumers")
class CustumerResource(
    private val custumerService: CustumerService

) {

    @PostMapping
    fun saveCustumer(@RequestBody custumerDto: CustumerDto): String{
        val savedCustumer = this.custumerService.save(custumerDto.toEntity())
        return "Custumer ${savedCustumer.email} saved!"
    }
}