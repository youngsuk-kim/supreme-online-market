package io.soboro.supreme.core.service

data class RegisterUser(
    val email: String,
    val password: String,
    val checkPassword: String,
    val city: String,
    val province: String,
    val detail: String,
    val username: String,
    val phoneNumber: String,
)
