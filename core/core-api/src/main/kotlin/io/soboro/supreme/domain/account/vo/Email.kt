package me.bread.supreme.integration.domain.account.vo

import me.bread.supreme.integration.domain.account.exception.InvalidFormatEmailException

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
