package me.dio.credit.applitcation.system.controller

import jakarta.validation.Valid
import me.dio.credit.applitcation.system.dto.CustumerDto
import me.dio.credit.applitcation.system.dto.CustumerUpdateDto
import me.dio.credit.applitcation.system.dto.CustumerView
import me.dio.credit.applitcation.system.entity.Custumer
import me.dio.credit.applitcation.system.service.impl.CustumerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/custumers")
class CustumerResource(
    private val custumerService: CustumerService

) {

    @PostMapping
    fun saveCustumer(@RequestBody @Valid custumerDto: CustumerDto):ResponseEntity<String> {
        val savedCustumer = this.custumerService.save(custumerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body( "Custumer ${savedCustumer.email} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustumerView> {
        val custumer: Custumer = this.custumerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustumerView(custumer))
    }

    @DeleteMapping("/{id}")
    fun deleteCustumer(@PathVariable id: Long) =
        this.custumerService.delete(id)

    @PatchMapping
    fun updateCustumer(
        @RequestParam(value = "custumerId") id: Long,
        @RequestBody @Valid custumerUpdateDto: CustumerUpdateDto
    ): ResponseEntity<CustumerView> {
       val custumer:Custumer = this.custumerService.findById(id)
        val custumerUpdate: Custumer = custumerUpdateDto.toEntity(custumer)
        val custumerUpdated: Custumer = this.custumerService.save(custumerUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustumerView(custumerUpdated))
    }

}