package io.soboro.supreme.web.api.support.error

import org.springframework.boot.logging.LogLevel
import org.springframework.http.HttpStatus

enum class ErrorType(val status: HttpStatus, val code: ErrorCode, val message: String, val logLevel: LogLevel) {
    DEFAULT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.E500, "An unexpected error has occurred.", LogLevel.ERROR),
    NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, ErrorCode.E404, "Target resource not found error has occurred", LogLevel.WARN),
    INVALID_ARG_ERROR(HttpStatus.BAD_REQUEST, ErrorCode.E400, "Invalid arguments error has occurred", LogLevel.WARN),
}
