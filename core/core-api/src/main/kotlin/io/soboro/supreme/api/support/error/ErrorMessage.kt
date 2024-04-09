package io.soboro.supreme.api.support.error

data class ErrorMessage private constructor(
    val code: String,
    val message: String,
    val data: Any? = null,
) {
    constructor(errorType: io.soboro.supreme.api.support.error.ErrorType, data: Any? = null) : this(
        code = errorType.code.name,
        message = errorType.message,
        data = data,
    )
}
