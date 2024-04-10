package io.soboro.supreme.presentation.rest.web.filter

import io.soboro.supreme.presentation.rest.config.jwt.JwtProcessor
import io.soboro.supreme.presentation.rest.config.jwt.JwtProcessor.Companion.CLAIM_KEY_EMAIL
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class AuthenticationFilter(
    private val jwtProcessor: JwtProcessor,
//    private val customUserDetails: CustomUserDetails,
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

        if (decodedJWT.getClaim(CLAIM_KEY_EMAIL).asInt() == -1) {
            throw IllegalStateException("JWT token is not valid")
        }

//        val authentication = UsernamePasswordAuthenticationToken(customUserDetails.username, customUserDetails.password)
        val authentication = UsernamePasswordAuthenticationToken("customUserDetails.username", "customUserDetails.password")

        SecurityContextHolder
            .getContext()
            .authentication = authentication

        filterChain.doFilter(request, response)
    }
}
