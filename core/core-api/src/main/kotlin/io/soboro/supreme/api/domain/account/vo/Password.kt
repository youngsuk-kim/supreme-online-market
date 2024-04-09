package me.bread.supreme.integration.domain.account.vo

import java.util.regex.Pattern

@JvmInline
value class Password(private val value: String) {
	companion object {
		private const val MIN_LENGTH = 8
		private val PASSWORD_PATTERN: Pattern =
			Pattern.compile(
				"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}\$",
			)
	}

	fun isValid(): Boolean {
		return value.length >= MIN_LENGTH && PASSWORD_PATTERN.matcher(value).matches()
	}

	fun meetsLengthRequirement(): Boolean {
		return value.length >= MIN_LENGTH
	}

	fun containsUpperCase(): Boolean {
		return value.any { it.isUpperCase() }
	}

	fun containsLowerCase(): Boolean {
		return value.any { it.isLowerCase() }
	}

	fun containsDigit(): Boolean {
		return value.any { it.isDigit() }
	}
}
