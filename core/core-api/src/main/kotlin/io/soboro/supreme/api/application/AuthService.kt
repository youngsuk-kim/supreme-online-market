package io.soboro.supreme.api.application

import me.bread.supreme.integration.domain.account.exception.NoAuthorizationException
import me.bread.supreme.integration.domain.account.repsository.AccountsRepository
import me.bread.supreme.integration.domain.account.validatior.FakeTokenValidator
import me.bread.supreme.integration.domain.account.validatior.TokenValidator

class AuthService(
	private val accountsRepository: AccountsRepository,
	private val tokenValidator: TokenValidator = FakeTokenValidator,
) {
	fun isValid(token: String): Boolean {
		if (tokenValidator.check(token) === TokenValidator.CheckResult.SUCCESS)
			{
				return true
			}

		throw NoAuthorizationException()
	}
}
