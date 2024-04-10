package io.soboro.supreme.core.api.domain.user.entity

import io.soboro.supreme.core.api.domain.order.vo.Address
import io.soboro.supreme.core.api.domain.user.enums.Role

class User(
    val username: String,
    val role: Role,
    var address: Address,
    val userSecret: UserSecret,
) {
    companion object {
        fun create(
            username: String,
            role: Role,
            address: Address,
            userSecret: UserSecret,
        ): User {
            return User(
                username = username,
                role = role,
                address = address,
                userSecret = userSecret
            )
        }
    }

    fun editPersonalInfo(newAddress: Address) = this.address.updateTo(newAddress)
}
