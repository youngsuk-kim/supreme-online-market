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
class UserRegisterService(
    private val userRepository: UserRepository,
) {
    @Transactional
    fun register(userRegister: UserRegister) {
        val user = User.create(
            username = userRegister.username,
            address = Address(userRegister.city, userRegister.province, userRegister.detail),
            userSecret = UserSecret(
                Email(userRegister.email),
                PhoneNumber(userRegister.phoneNumber),
                Password(userRegister.password),
            ),
        )

        user.checkPassword(Password(userRegister.checkPassword))
        user.checkDuplicate()

        userRepository.save(user)
    }

    private fun User.checkDuplicate() {
        if (userRepository.existsByEmail(this.email())) throw DuplicateEmailException()
    }

    private fun User.checkPassword(password: Password) {
        if (this.userSecret.password != password) throw InvalidPasswordException()
    }
}
