package io.soboro.supreme.support.web.response

import io.soboro.supreme.support.web.error.ErrorMessage
import io.soboro.supreme.web.api.support.error.ErrorType
import io.soboro.supreme.web.api.support.response.ResultType

data class ApiResponse<T> private constructor(
    val result: ResultType,
    val data: T? = null,
    val error: ErrorMessage? = null,
) {
    companion object {
        fun success(): ApiResponse<Any> {
            return ApiResponse(
                ResultType.SUCCESS,
                null,
                null,
            )
        }

        fun <S> success(data: S): ApiResponse<S> {
            return ApiResponse(
                ResultType.SUCCESS,
                data,
                null,
            )
        }

        fun <S> error(error: ErrorType, errorData: Any? = null): ApiResponse<S> {
            return ApiResponse(
                ResultType.ERROR,
                null,
                ErrorMessage(error, errorData),
            )
        }
    }
}
