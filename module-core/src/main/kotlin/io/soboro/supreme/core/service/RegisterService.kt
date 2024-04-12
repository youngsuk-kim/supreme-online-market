package io.soboro.supreme.core.service

import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.model.user.exception.DuplicateEmailException
import io.soboro.supreme.core.model.user.exception.InvalidPasswordException
import io.soboro.supreme.core.model.user.vo.Password
import io.soboro.supreme.core.model.user.UserRepository
import io.soboro.supreme.core.support.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RegisterService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {
    @Transactional
    fun register(user: User, checkPassword: String) {
        user.validate(Password(checkPassword))
        user.validateDuplicate()

        user.encodePassword(passwordEncoder)

        userRepository.save(user)
    }

    private fun User.validateDuplicate() {
        if (userRepository.existsByEmail(this.email())) throw DuplicateEmailException()
    }

    private fun User.validate(checkPassword: Password) {
        if (this.password() != checkPassword) throw InvalidPasswordException()
    }
}
