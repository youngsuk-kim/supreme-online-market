package io.soboro.supreme.core.model.user.vo

import io.soboro.supreme.core.model.user.exception.InvalidFormatEmailException

@JvmInline
value class Email(private val value: String) {
    init {
        if (!isValidEmail(value)) {
            throw InvalidFormatEmailException()
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$")
        return emailRegex.matches(email)
    }
}
