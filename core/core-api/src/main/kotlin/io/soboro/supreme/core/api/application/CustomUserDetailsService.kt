@file:Suppress("UNREACHABLE_CODE")

package io.soboro.supreme.core.api.application

import io.soboro.supreme.core.api.domain.user.repsository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository,
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByUsername(username)

        if (user != null) {
            return CustomUserDetails(user.userSecret)
        }

        throw ResponseStatusException(
            HttpStatus.UNAUTHORIZED,
            String.format("No user found")
        )

    }
}