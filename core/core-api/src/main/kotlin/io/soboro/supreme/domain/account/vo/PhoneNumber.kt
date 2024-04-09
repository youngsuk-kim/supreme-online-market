package me.bread.supreme.integration.domain.account.vo

import java.util.regex.Pattern

@JvmInline
value class PhoneNumber(private val value: String) {
	companion object {
		private val PHONE_NUMBER_PATTERN = Pattern.compile("^\\+[1-9]\\d{1,14}\$")
	}

	fun isValid(): Boolean {
		return PHONE_NUMBER_PATTERN.matcher(value).matches()
	}
}
