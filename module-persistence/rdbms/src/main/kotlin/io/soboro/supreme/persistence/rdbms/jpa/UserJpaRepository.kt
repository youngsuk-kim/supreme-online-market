package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.model.user.vo.Email
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long> {
    fun existsByUserSecretEmail(email: Email): Boolean
    fun findByUsername(username: String): User?
    fun findByUserSecretEmail(email: Email): User?
    fun findByUserSecretToken(token: String): User?
}
