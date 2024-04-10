package io.soboro.supreme.core.model.user.entity

import io.soboro.supreme.core.model.BaseEntity
import io.soboro.supreme.core.model.order.vo.Address
import jakarta.persistence.*

@Entity @Table(name = "users")
class User(
    @Column(unique = true) val username: String,
    @Embedded var address: Address,
    @OneToOne val userSecret: UserSecret,
) : BaseEntity() {
    companion object {
        fun create(
            username: String,
            address: Address,
            userSecret: UserSecret,
        ): User {
            return User(
                username = username,
                address = address,
                userSecret = userSecret,
            )
        }
    }

    fun password() = this.userSecret.password.toString()

    fun editPersonalInfo(newAddress: Address) = this.address.updateTo(newAddress)
}
