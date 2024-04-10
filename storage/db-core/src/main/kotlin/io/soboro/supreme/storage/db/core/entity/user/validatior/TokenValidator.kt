package io.soboro.supreme.storage.db.core.entity.user.validatior

interface TokenValidator {
    enum class CheckResult {
        SUCCESS,
        FAIL,
    }

    fun check(token: String): CheckResult
}
