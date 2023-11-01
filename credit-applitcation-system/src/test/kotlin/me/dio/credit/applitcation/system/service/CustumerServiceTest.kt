package me.dio.credit.applitcation.system.service

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import me.dio.credit.applitcation.system.entity.Address
import me.dio.credit.applitcation.system.entity.Custumer
import me.dio.credit.applitcation.system.exception.BusinessException
import me.dio.credit.applitcation.system.reporsitory.CustumerRepository
import me.dio.credit.applitcation.system.service.impl.CustumerService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.util.*

@ExtendWith(MockKExtension::class)
class CustumerServiceTest {
    @MockK
    lateinit var custumerRepository: CustumerRepository

    @InjectMockKs
    lateinit var custumerService: CustumerService

    @Test
    fun `should create custumer`() {
        //given
        val fakeCustumer: Custumer = buildCustumer()
        every { custumerRepository.save(any()) } returns fakeCustumer
        //when
        val actual: Custumer = custumerService.save(fakeCustumer)
        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCustumer)
        verify(exactly = 1){custumerRepository.save(fakeCustumer)}
    }

    @Test
    fun `should find custumer by id`(){
        //given
        val fakeId:Long = Random().nextLong()
        val fakeCustumer: Custumer = buildCustumer(id = fakeId)
        every { custumerRepository.findById(fakeId) }returns Optional.of(fakeCustumer)
        //when
        val actual: Custumer = custumerService.findById(fakeId)

        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isExactlyInstanceOf(Custumer::class.java)
        Assertions.assertThat(actual).isSameAs(fakeCustumer)
        verify(exactly = 1){custumerRepository.findById(fakeId)}


    }

    @Test
    fun `should not find Custumer by invalid id and throw Business Exception`(){
        //given
        val fakeId:Long = Random().nextLong()
        every { custumerRepository.findById(fakeId) }returns Optional.empty()
        //when
        //then
        Assertions.assertThatExceptionOfType(BusinessException::class.java)
            .isThrownBy { custumerService.findById(fakeId) }
            .withMessage("Id $fakeId not found")
        verify(exactly = 1) { custumerRepository.findById(fakeId) }
    }

    @Test
    fun `should delete custumer by id`(){
        //given
        val fakeId:Long = Random().nextLong()
        val fakeCustumer: Custumer = buildCustumer(id = fakeId)
        every { custumerRepository.findById(fakeId) }returns Optional.of(fakeCustumer)
        every { custumerRepository.delete(fakeCustumer) } just runs
        //when
        custumerService.delete(fakeId)
        //then
        verify(exactly = 1) { custumerRepository.findById(fakeId) }
        verify(exactly = 1) { custumerRepository.delete(fakeCustumer) }
    }

    private fun buildCustumer(
        firstName: String = "Douglas",
        lastName: String = "Souza",
        cpf: String = "905.886.858-36",
        email: String = "douglas.full.ti@gmail.com",
        password: String = "1234",
        zipCode: String = "13245",
        street: String = "123456",
        income: BigDecimal = BigDecimal.valueOf(1000.0),
        id: Long = 1L
    ) = Custumer(
        firstname = firstName,
        lastname = lastName,
        cpf = cpf,
        email = email,
        password = password,
        address = Address(zipcode = zipCode, street = street),
        income = income,
        id = id
    )
}