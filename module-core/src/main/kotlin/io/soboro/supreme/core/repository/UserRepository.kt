package io.soboro.supreme.core.repository

import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.model.user.vo.Email
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {
    fun findByUsername(username: String): User?
    fun existsByEmail(email: Email): Boolean
    fun save(user: User)
}
