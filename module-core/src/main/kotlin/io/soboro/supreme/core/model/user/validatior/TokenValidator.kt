package io.soboro.supreme.core.model.user.validatior

interface TokenValidator {
    enum class CheckResult {
        SUCCESS,
        FAIL,
    }

    fun check(token: String): CheckResult
}
