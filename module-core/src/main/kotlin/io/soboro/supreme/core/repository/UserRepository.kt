package io.soboro.supreme.core.repository

import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.model.user.vo.Email
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {
    fun findByUsername(username: String): User?
    fun findByEmail(email: Email): User?
    fun save(user: User)
}
