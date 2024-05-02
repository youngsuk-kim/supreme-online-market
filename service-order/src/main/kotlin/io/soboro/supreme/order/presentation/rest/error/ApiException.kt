package io.soboro.supreme.order.presentation.rest.error

class ApiException(
    val errorType: ErrorType,
    val data: Any? = null,
) : RuntimeException(errorType.message)
