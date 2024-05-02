package io.soboro.supreme.order.presentation.rest

import io.soboro.supreme.order.presentation.rest.error.ApiException
import io.soboro.supreme.order.presentation.rest.error.ErrorType
import io.soboro.supreme.order.presentation.rest.response.ApiResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.logging.LogLevel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(ApiException::class)
    fun handleApiException(e: ApiException): ResponseEntity<ApiResponse<Any>> {
        logBasedOnLevel(e.errorType.logLevel, e.message, e)
        val response = ApiResponse.error<Any>(e.errorType, e.data)
        return ResponseEntity(response, e.errorType.status)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<ApiResponse<Any>> {
        log.error("IllegalArgumentException: {}", e.message, e)
        val response = ApiResponse.error<Any>(ErrorType.INVALID_ARG_ERROR)
        return ResponseEntity(response, ErrorType.INVALID_ARG_ERROR.status)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse<Any>> {
        log.error("Exception: {}", e.message, e)
        val response = ApiResponse.error<Any>(ErrorType.DEFAULT_ERROR)
        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    private fun logBasedOnLevel(logLevel: LogLevel, message: String?, exception: Throwable) {
        when (logLevel) {
            LogLevel.ERROR -> log.error("ApiException: {}", message, exception)
            LogLevel.WARN -> log.warn("ApiException: {}", message, exception)
            else -> log.info("ApiException: {}", message, exception)
        }
    }
}
