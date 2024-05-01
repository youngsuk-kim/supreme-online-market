package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.model.user.exception.UserNotFoundException
import io.soboro.supreme.core.model.user.repository.UserRepository
import io.soboro.supreme.core.model.user.vo.Email
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryAdapter(
    private val userJpaRepository: UserJpaRepository,
) : UserRepository {
    override fun findByUsername(username: String): User? {
        return userJpaRepository.findByUsername(username)
    }

    override fun existsByEmail(email: Email): Boolean {
        return userJpaRepository.existsByUserSecretEmail(email)
    }

    override fun save(user: User) {
        userJpaRepository.save(user)
    }

    override fun findByEmail(email: Email): User? {
        return userJpaRepository.findByUserSecretEmail(email)
    }

    override fun findByToken(token: String): User? {
        return userJpaRepository.findByUserSecretToken(token)
    }

    override fun findById(id: Long): User? {
        return userJpaRepository.findById(id).orElseThrow(::UserNotFoundException)
    }
}
