package io.soboro.supreme.core.support

interface PasswordEncoder {
    fun encode(plain: String): String
    fun matches(plain: String, encoded: String): Boolean
}