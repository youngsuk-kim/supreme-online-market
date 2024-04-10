package io.soboro.supreme.core.api.domain.user.entity

import io.soboro.supreme.core.api.domain.user.vo.Email
import io.soboro.supreme.core.api.domain.user.vo.Password
import io.soboro.supreme.core.api.domain.user.vo.PhoneNumber
import jakarta.persistence.*

@Entity
class UserSecret(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @Column(nullable = false, unique = true) val email: Email,
    @Column(nullable = false, unique = true) val phoneNumber: PhoneNumber,
    @Column(nullable = false) val password: Password,
)
