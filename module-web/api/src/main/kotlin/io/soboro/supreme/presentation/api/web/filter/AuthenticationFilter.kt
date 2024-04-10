package io.soboro.supreme.presentation.api.web.filter

import io.soboro.supreme.presentation.api.support.security.AuthenticationProvider
import io.soboro.supreme.presentation.api.support.security.JwtProcessor
import io.soboro.supreme.presentation.api.support.security.JwtProcessor.Companion.CLAIM_KEY_USERNAME
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

private const val INVALID_JWT_CODE = -1

@Component
class AuthenticationFilter(
    private val jwtProcessor: JwtProcessor,
    private val authenticationProvider: AuthenticationProvider
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val authorizationHeader =
            request.getHeaders(HttpHeaders.AUTHORIZATION)
                ?: throw IllegalStateException("Authorization header is missing")

        val decodedJWT = jwtProcessor.validateToken(authorizationHeader.nextElement())

        if (decodedJWT.getClaim(CLAIM_KEY_USERNAME).asInt() == INVALID_JWT_CODE) {
            throw IllegalStateException("JWT token is not valid")
        }

        authenticationProvider.provideAuthentication(decodedJWT.getClaim(CLAIM_KEY_USERNAME).asString())

        filterChain.doFilter(request, response)
    }
}
