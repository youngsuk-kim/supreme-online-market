package io.soboro.supreme.core.repository

import io.soboro.supreme.core.model.user.entity.User
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {
    fun findByUsername(username: String): User?
}
