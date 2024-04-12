package io.soboro.supreme.web.api.web.controller.v1.request

data class UserLoginRequest(
    val email: String,
    val password: String,
)
