package io.soboro.supreme.core.service

interface PasswordEncoder {
    fun encode(plain: String): String
    fun matches(plain: String, encoded: String): Boolean
}