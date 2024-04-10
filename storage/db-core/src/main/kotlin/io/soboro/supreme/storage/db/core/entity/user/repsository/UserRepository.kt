package io.soboro.supreme.storage.db.core.entity.user.repsository

import io.soboro.supreme.storage.db.core.entity.user.entity.User

interface UserRepository {
    fun save(user: User)
    fun findByUsername(username: String): User?
}
