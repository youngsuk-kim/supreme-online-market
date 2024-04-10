package io.soboro.supreme.presentation.api.support.security

import io.soboro.supreme.core.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class CustomUserDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = (userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User with username $username not found"))

        return CustomUserDetails(user.username, user.password())
    }
}