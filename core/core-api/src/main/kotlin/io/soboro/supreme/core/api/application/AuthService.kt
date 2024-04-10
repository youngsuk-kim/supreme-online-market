package io.soboro.supreme.core.api.application

import io.soboro.supreme.storage.db.core.entity.user.exception.NoAuthorizationException
import io.soboro.supreme.storage.db.core.entity.user.repsository.UserRepository
import io.soboro.supreme.storage.db.core.entity.user.validatior.FakeTokenValidator
import io.soboro.supreme.storage.db.core.entity.user.validatior.TokenValidator

class AuthService(
    private val userRepository: UserRepository,
    private val tokenValidator: TokenValidator = FakeTokenValidator,
) {
    fun isValid(token: String): Boolean {
        if (tokenValidator.check(token) === TokenValidator.CheckResult.SUCCESS) {
            return true
        }

        throw NoAuthorizationException()
    }

    fun login(
        email: String,
        password: String,
    ) {}
}
