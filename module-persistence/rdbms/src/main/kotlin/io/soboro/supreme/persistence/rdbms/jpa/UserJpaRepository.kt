package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.repository.OrderRepository
import io.soboro.supreme.core.repository.UserRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface UserJpaRepository : UserRepository, JpaRepository<User, Long>

@Repository
class UserRepositoryAdapter(
    private val userJpaRepository: CartJpaRepository
): UserRepository {
    override fun findByUsername(username: String): User? {
        TODO("Not yet implemented")
    }
}