package io.soboro.supreme.web.api.support.security

import io.soboro.supreme.core.model.user.repository.UserRepository
import io.soboro.supreme.core.model.user.vo.Email
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class
CustomUserDetailsService(
    private val userRepository: UserRepository,
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = (
            userRepository.findByEmail(Email(username))
                ?: throw UsernameNotFoundException("User with username $username not found")
            )

        return CustomUserDetails(user.username, user.password().toString())
    }
}
