package io.soboro.supreme.web.api.web.controller.v1.request

import io.soboro.supreme.core.model.common.Address
import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.model.user.entity.UserSecret
import io.soboro.supreme.core.model.user.vo.Email
import io.soboro.supreme.core.model.user.vo.Password
import io.soboro.supreme.core.model.user.vo.PhoneNumber

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
    fun toUser(): User {
        return User.create(
            username = this.username,
            address = Address(this.city, this.province, this.detail),
            userSecret = UserSecret(
                email = Email(this.email),
                phoneNumber = PhoneNumber(this.phoneNumber),
                password = Password(this.password),
            ),
        )
    }
}
