package io.soboro.supreme.web.api.web.filter

import io.soboro.supreme.web.api.support.security.JwtProcessor
import io.soboro.supreme.web.api.support.security.SecurityConfiguration
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.core.annotation.Order
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.util.AntPathMatcher
import org.springframework.web.filter.OncePerRequestFilter

@Order(0)
@Component
class AuthenticationFilter(
    private val jwtProcessor: JwtProcessor,
    private val userDetailsService: UserDetailsService,
) : OncePerRequestFilter() {

    companion object {
        const val INVALID_JWT_CODE = -1
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        if (request.getHeaders(HttpHeaders.AUTHORIZATION) == null) {
            throw IllegalStateException("Authorization header is missing")
        }

        val decodedJWT = jwtProcessor.validateToken(request.getHeader(HttpHeaders.AUTHORIZATION))

        if (decodedJWT.getClaim(JwtProcessor.CLAIM_KEY_USERNAME).asInt() == INVALID_JWT_CODE) {
            throw IllegalStateException("JWT token is not valid")
        }

        val userDetails = userDetailsService.loadUserByUsername(decodedJWT.getClaim(JwtProcessor.CLAIM_KEY_USERNAME).asString())
        SecurityContextHolder.getContext().authentication =
            UsernamePasswordAuthenticationToken(userDetails, userDetails.authorities)

        filterChain.doFilter(request, response)
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        return SecurityConfiguration.allowedUrls.any { AntPathMatcher().match(it, request.servletPath) }
    }
}
