package io.soboro.supreme.core.model.user.validatior

object FakeTokenValidator : TokenValidator {
    private const val VALID_TOKEN = "valid-token"

    override fun check(token: String): TokenValidator.CheckResult {
        if (token == VALID_TOKEN) {
            return TokenValidator.CheckResult.SUCCESS
        }

        return TokenValidator.CheckResult.FAIL
    }
}
