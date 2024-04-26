package io.soboro.supreme.persistence.rdbms.config

import io.soboro.supreme.core.model.common.Address
import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.model.user.entity.UserSecret
import io.soboro.supreme.core.model.user.vo.Email
import io.soboro.supreme.core.model.user.vo.Password
import io.soboro.supreme.core.model.user.vo.PhoneNumber
import io.soboro.supreme.core.support.PasswordEncoder
import io.soboro.supreme.persistence.rdbms.jpa.UserJpaRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class InitDatabase(
    private val userJpaRepository: UserJpaRepository,
    private val passwordEncoder: PasswordEncoder,
) {

    @PostConstruct
    @Transactional
    fun init() {
        val user = User.create(
            username = "test",
            address = Address("서울시", "강남구", "비싸 오피스텔"),
            userSecret = UserSecret(
                Email("thayer@naver.com"),
                PhoneNumber("01053092392"),
                Password(passwordEncoder.encode("1234")),
            ),
        )

        userJpaRepository.save(user)
    }
}
