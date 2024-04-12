package io.soboro.supreme.web.api.web.controller.v1.request

import io.soboro.supreme.core.service.RegisterUser

data class UserRegisterRequest(
    val email: String,
    val phoneNumber: String,
    val username: String,
    val password: String,
    val checkPassword: String,
    val city: String,
    val province: String,
    val detail: String,
) {
    fun toRegisterUser(): RegisterUser {
        return RegisterUser(
            email = email,
            password = password,
            city = city,
            province = province,
            detail = detail,
            checkPassword = checkPassword,
            phoneNumber = phoneNumber,
            username = username,
        )
    }
}
