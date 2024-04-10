package io.soboro.supreme.presentation.api.support.error

class ApiException(
    val errorType: ErrorType,
    val data: Any? = null,
) : RuntimeException(errorType.message)
