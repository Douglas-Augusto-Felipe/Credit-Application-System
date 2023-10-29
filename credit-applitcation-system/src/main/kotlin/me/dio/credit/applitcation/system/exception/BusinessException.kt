package me.dio.credit.applitcation.system.exception

data  class BusinessException(override val message: String?) : RuntimeException(message)