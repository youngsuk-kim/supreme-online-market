package io.soboro.supreme.storage.db.core.entity.user.entity

import io.soboro.supreme.storage.db.core.entity.BaseEntity
import io.soboro.supreme.storage.db.core.entity.order.vo.Address
import io.soboro.supreme.storage.db.core.entity.user.enums.Role
import jakarta.persistence.Entity

@Entity
class User(
    val username: String,
    val role: Role,
    var address: Address,
    val userSecret: UserSecret,
): BaseEntity() {
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
