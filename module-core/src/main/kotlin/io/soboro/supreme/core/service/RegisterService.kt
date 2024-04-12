package io.soboro.supreme.core.service

import io.soboro.supreme.core.model.order.vo.Address
import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.model.user.entity.UserSecret
import io.soboro.supreme.core.model.user.exception.DuplicateEmailException
import io.soboro.supreme.core.model.user.exception.InvalidPasswordException
import io.soboro.supreme.core.model.user.vo.Email
import io.soboro.supreme.core.model.user.vo.Password
import io.soboro.supreme.core.model.user.vo.PhoneNumber
import io.soboro.supreme.core.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RegisterService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun register(registerUser: RegisterUser) {
        registerUser.checkPassword()
        registerUser.checkDuplicate()

        val user = User.create(
            username = registerUser.username,
            address = Address(registerUser.city, registerUser.province, registerUser.detail),
            userSecret = UserSecret(
                Email(registerUser.email),
                PhoneNumber(registerUser.phoneNumber),
                Password(passwordEncoder.encode(registerUser.password)),
            ),
        )

        userRepository.save(user)
    }

    private fun RegisterUser.checkDuplicate() {
        if (userRepository.existsByEmail(Email(this.email))) throw DuplicateEmailException()
    }

    private fun RegisterUser.checkPassword() {
        if (this.password != checkPassword) throw InvalidPasswordException()
    }
}
