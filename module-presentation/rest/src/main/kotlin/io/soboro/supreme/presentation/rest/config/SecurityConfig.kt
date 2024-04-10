package io.soboro.supreme.presentation.rest.config

import io.soboro.supreme.presentation.rest.web.filter.AuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authenticationFilter: AuthenticationFilter,
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun filterChain(
        httpSecurity: HttpSecurity,
    ): SecurityFilterChain {
        httpSecurity
            .httpBasic { it.disable() }
            .csrf { it.disable() }
            .sessionManagement { it.disable() }
            .authorizeHttpRequests { it.requestMatchers("/health", "/api/v1/register", "/api/v1/login").permitAll() }
            .addFilterBefore(authenticationFilter, BasicAuthenticationFilter::class.java)

        return httpSecurity.build()
    }
}
