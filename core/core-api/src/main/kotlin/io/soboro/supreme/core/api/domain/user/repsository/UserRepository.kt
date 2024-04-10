package io.soboro.supreme.core.api.domain.user.repsository

import io.soboro.supreme.core.api.domain.user.entity.User

interface UserRepository {
    fun save(user: User)
    fun findByUsername(username: String): User?
}
