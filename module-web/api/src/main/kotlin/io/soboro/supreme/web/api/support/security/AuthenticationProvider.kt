package io.soboro.supreme.web.api.support.security

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class AuthenticationProvider(
    private val userDetailsService: CustomUserDetailsService
) {
    fun provideAuthentication(username: String): Authentication {
        val userDetails = userDetailsService.loadUserByUsername(username)

        return UsernamePasswordAuthenticationToken(userDetails, userDetails.authorities)
    }
}