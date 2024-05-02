package io.soboro.supreme.order.presentation.rest.response

import io.soboro.supreme.order.presentation.rest.error.ErrorMessage
import io.soboro.supreme.order.presentation.rest.error.ErrorType

data class ApiResponse<T> private constructor(
    val result: ResultType? = null,
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
