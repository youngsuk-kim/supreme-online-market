package io.soboro.supreme.core.api.domain.user.validatior

interface TokenValidator {
    enum class CheckResult {
        SUCCESS,
        FAIL,
    }

    fun check(token: String): CheckResult
}
