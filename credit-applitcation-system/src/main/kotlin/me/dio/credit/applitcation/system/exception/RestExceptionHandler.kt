package me.dio.credit.applitcation.system.exception

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class RestExceptionHandler {
    @ExceptionHandler(DataAccessException::class)
    fun handlerValidException(ex: DataAccessException):
            ResponseEntity<ExceptionDetails> {
        return ResponseEntity(ExceptionDetails(
            title = "Conflict! Consult the documentation",
            timetamp = LocalDateTime.now(),
            status = HttpStatus.BAD_REQUEST.value(),
            exception = ex.javaClass.toString(),
            details = mutableMapOf(ex.cause.toString() to ex.message)
        ),HttpStatus.CONFLICT)
    }
    @ExceptionHandler(BusinessException::class)
    fun handlerValidException(ex: BusinessException):
            ResponseEntity<ExceptionDetails> {
        return ResponseEntity(ExceptionDetails(
            title = "Bad Request! Consult the documentation",
            timetamp = LocalDateTime.now(),
            status = HttpStatus.BAD_REQUEST.value(),
            exception = ex.javaClass.toString(),
            details = mutableMapOf(ex.cause.toString() to ex.message)
        ),HttpStatus.BAD_REQUEST)
    }
}