package io.soboro.supreme.web.api.web.controller.v1.request

data class UserRegisterRequest(
    val email: String,
    val password: String,
    val checkPassword: String,
    val city: String,
    val province: String,
    val detail: String,
)
