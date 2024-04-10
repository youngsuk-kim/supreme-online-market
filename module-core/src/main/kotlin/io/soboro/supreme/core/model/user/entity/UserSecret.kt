package io.soboro.supreme.core.model.user.entity

import io.soboro.supreme.core.model.BaseEntity
import io.soboro.supreme.core.model.user.vo.Email
import io.soboro.supreme.core.model.user.vo.Password
import io.soboro.supreme.core.model.user.vo.PhoneNumber
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class UserSecret(
    @Column(nullable = false, unique = true) val email: Email,
    @Column(nullable = false, unique = true) val phoneNumber: PhoneNumber,
    @Column(nullable = false) val password: Password,
) : BaseEntity()
