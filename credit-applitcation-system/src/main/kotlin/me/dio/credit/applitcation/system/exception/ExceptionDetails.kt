package me.dio.credit.applitcation.system.exception

import java.time.LocalDateTime

data class ExceptionDetails(
    val title: String,
    val timetamp: LocalDateTime,
    val status: Int,
    val exception: String,
    val details: MutableMap<String, String?>
)