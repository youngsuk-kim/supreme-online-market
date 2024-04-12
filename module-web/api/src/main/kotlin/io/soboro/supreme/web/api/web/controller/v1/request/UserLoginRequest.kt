package io.soboro.supreme.web.api.web.controller.v1.request

import io.soboro.supreme.core.service.LoginUser

data class UserLoginRequest(
    val email: String,
    val password: String
) {
    fun toUserLogin(): LoginUser {
        return LoginUser(email, password)
    }
}
