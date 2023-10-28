package me.dio.credit.applitcation.system.controller

import me.dio.credit.applitcation.system.dto.CreditDto
import me.dio.credit.applitcation.system.dto.CreditViewList
import me.dio.credit.applitcation.system.entity.Credit
import me.dio.credit.applitcation.system.service.impl.CreditService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditService: CreditService
) {

    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto): String {
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return "Credit ${credit.creditCode} - Custumer ${credit.custumer?.firstname} saved!"
    }

    @GetMapping
    fun findAllByCustumerId(@RequestParam(value = "custumerId") custumerId: Long): List<CreditViewList> {
        return this.creditService.findAllByCustumer(custumerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
    }
}