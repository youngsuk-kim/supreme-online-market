package io.soboro.supreme.core.service

import io.soboro.supreme.core.repository.UserRepository

class AuthService(
    private val userRepository: UserRepository,
) {

    fun login(
        email: String,
        password: String,
    ) {}
}
