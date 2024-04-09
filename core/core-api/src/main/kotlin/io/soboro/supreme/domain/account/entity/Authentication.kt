package me.bread.supreme.integration.domain.account.entity

import me.bread.supreme.integration.domain.account.vo.Email
import me.bread.supreme.integration.domain.account.vo.Password
import me.bread.supreme.integration.domain.account.vo.PhoneNumber

data class Authentication(
	val email: Email,
	val password: Password,
	val phoneNumber: PhoneNumber,
)
