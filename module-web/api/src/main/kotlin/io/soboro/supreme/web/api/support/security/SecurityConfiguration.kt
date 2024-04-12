package io.soboro.supreme.web.api.support.security

import io.soboro.supreme.web.api.web.filter.AuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val jwtAuthenticationFilter: AuthenticationFilter,
): io.soboro.supreme.core.support.PasswordEncoder {

    companion object {
        val allowedUrls = arrayOf(
            "/",
            "/health",
            "/api/v1/register",
            "/api/v1/login",

            "/h2-console/**",
            "/js/**",
            "/css/**",
            "/image/**",
            "/fonts/**",
            "/favicon.ico",
        )
    }

    @Bean
    fun filterChain(
        http: HttpSecurity,
    ): SecurityFilterChain {
        http.csrf { it.disable() }
            .headers { it.frameOptions { frameOptions -> frameOptions.sameOrigin() } }
            .authorizeHttpRequests {
                it.requestMatchers(*allowedUrls).permitAll()
                    .anyRequest().authenticated()
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter::class.java)

        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()

        configuration.setAllowedOriginPatterns(listOf("*"))
        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
        configuration.allowedHeaders = listOf("*")

        val source = UrlBasedCorsConfigurationSource()
        UrlBasedCorsConfigurationSource().registerCorsConfiguration("/**", configuration)

        return source
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    override fun encode(plain: String): String {
        return passwordEncoder().encode(plain)
    }

    override fun matches(plain: String, encoded: String): Boolean {
        return passwordEncoder().matches(plain, encoded)
    }
}
