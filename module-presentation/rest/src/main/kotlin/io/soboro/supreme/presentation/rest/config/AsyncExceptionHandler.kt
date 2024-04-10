package io.soboro.supreme.presentation.rest.config

import io.soboro.supreme.presentation.rest.support.error.ApiException
import org.slf4j.LoggerFactory
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.boot.logging.LogLevel
import java.lang.reflect.Method

class AsyncExceptionHandler : AsyncUncaughtExceptionHandler {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun handleUncaughtException(e: Throwable, method: Method, vararg params: Any?) {
        if (e is ApiException) {
            when (e.errorType.logLevel) {
                LogLevel.ERROR -> log.error("CoreApiException : {}", e.message, e)
                LogLevel.WARN -> log.warn("CoreApiException : {}", e.message, e)
                else -> log.info("CoreApiException : {}", e.message, e)
            }
        } else {
            log.error("Exception : {}", e.message, e)
        }
    }
}
