package io.soboro.supreme.core.model.user.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.user.vo.Email
import io.soboro.supreme.core.model.user.vo.Password
import io.soboro.supreme.core.model.user.vo.PhoneNumber
import io.soboro.supreme.core.support.PasswordEncoder
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class UserSecret(
    @Column(nullable = false, unique = true) val email: Email,
    @Column(nullable = false, unique = true) val phoneNumber: PhoneNumber,
    @Column(nullable = false) var password: Password,
) : BaseEntity() {
    fun encode(passwordEncoder: PasswordEncoder) {
        this.password = Password(passwordEncoder.encode(this.password.toString()))
    }
}
