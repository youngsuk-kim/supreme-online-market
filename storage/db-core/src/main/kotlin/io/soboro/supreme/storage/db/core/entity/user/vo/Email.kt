package io.soboro.supreme.storage.db.core.entity.user.vo

import io.soboro.supreme.storage.db.core.entity.user.exception.InvalidFormatEmailException

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
