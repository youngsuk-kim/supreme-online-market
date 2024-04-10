package io.soboro.supreme.storage.db.core.entity.user.validatior

object FakeTokenValidator : TokenValidator {
    private const val VALID_TOKEN = "valid-token"

    override fun check(token: String): TokenValidator.CheckResult {
        if (token == VALID_TOKEN) {
            return TokenValidator.CheckResult.SUCCESS
        }

        return TokenValidator.CheckResult.FAIL
    }
}
