package io.soboro.supreme.core.application

import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.model.user.exception.UserNotFoundException
import io.soboro.supreme.core.model.user.repository.UserRepository
import io.soboro.supreme.core.model.user.vo.Email
import io.soboro.supreme.core.support.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {

    @Transactional
    fun login(email: String, password: String, token: String) {
        val user = userRepository.findByEmail(Email(email)) ?: throw UserNotFoundException()

        save(token, user)
    }

    @Transactional(readOnly = true)
    fun validate(email: String, password: String) {
        val user = userRepository.findByEmail(Email(email)) ?: throw UserNotFoundException()
        if (!user.checkPasswordOk(password)) {
            throw IllegalArgumentException("Password is not correct")
        }
    }

    @Transactional(readOnly = true)
    fun getUserFromToken(token: String): User {
        return userRepository.findByToken(token) ?: throw UserNotFoundException()
    }

    private fun save(token: String, user: User) {
        user.set(token)
        userRepository.save(user)
    }

    fun User.checkPasswordOk(password: String): Boolean {
        return passwordEncoder.matches(password, this.password().toString())
    }
}
