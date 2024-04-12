package io.soboro.supreme.core.model.user.entity

import io.soboro.supreme.core.model.BaseEntity
import io.soboro.supreme.core.model.order.vo.Address
import io.soboro.supreme.core.service.PasswordEncoder
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(
    @Column(unique = true) val username: String,
    @Embedded var address: Address,
    @OneToOne(cascade = [CascadeType.ALL]) val userSecret: UserSecret,
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

    fun encodePassword(passwordEncoder: PasswordEncoder) {
        this.userSecret.encode(passwordEncoder)
    }

    fun email() = this.userSecret.email

    fun password() = this.userSecret.password

    fun editPersonalInfo(newAddress: Address) = this.address.updateTo(newAddress)
}
