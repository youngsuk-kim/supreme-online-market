package io.soboro.supreme.core.service

interface PasswordEncoder {
    fun encode(plain: String): String
}