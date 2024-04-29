package io.soboro.supreme.core.model.user.entity

import io.soboro.supreme.core.model.common.Address
import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.support.PasswordEncoder
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

    fun set(token: String) {
        this.userSecret.token = token
    }

    fun email() = this.userSecret.email

    fun password() = this.userSecret.password
}
