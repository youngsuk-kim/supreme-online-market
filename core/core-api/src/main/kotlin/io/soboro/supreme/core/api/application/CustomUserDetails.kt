package io.soboro.supreme.core.api.application

import io.soboro.supreme.core.api.domain.user.entity.UserSecret
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(
    private val userSecret: UserSecret,
) : UserDetails {
    fun getPasswordCredential(): UserSecret {
        return userSecret
    }

    override fun getPassword(): String {
        return userSecret.password.toString()
    }

    override fun getUsername(): String {
        return userSecret.email.toString()
    }

    // 권한 구현 X
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf()
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}