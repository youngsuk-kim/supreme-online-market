package io.soboro.supreme.api.support.response

import io.soboro.supreme.api.support.error.ErrorMessage
import io.soboro.supreme.core.api.support.error.ErrorType

data class ApiResponse<T> private constructor(
    val result: ResultType,
    val data: T? = null,
    val error: io.soboro.supreme.api.support.error.ErrorMessage? = null,
) {
    companion object {
        fun success(): ApiResponse<Any> {
            return ApiResponse(ResultType.SUCCESS, null, null)
        }

        fun <S> success(data: S): ApiResponse<S> {
            return ApiResponse(ResultType.SUCCESS, data, null)
        }

        fun <S> error(error: ErrorType, errorData: Any? = null): ApiResponse<S> {
            return ApiResponse(ResultType.ERROR, null,
                io.soboro.supreme.api.support.error.ErrorMessage(error, errorData)
            )
        }
    }
}
