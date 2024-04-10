package io.soboro.supreme.presentation.rest.support.error

class ApiException(
    val errorType: ErrorType,
    val data: Any? = null,
) : RuntimeException(errorType.message)
