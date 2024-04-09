package me.bread.supreme.integration.domain.account.entity

import me.bread.supreme.integration.domain.account.enums.Role
import me.bread.supreme.integration.domain.order.vo.Address

class Accounts(
	val role: Role,
	var address: Address,
	val authentication: Authentication,
) {
	companion object {
		fun create(
			role: Role,
			address: Address,
			authentication: Authentication,
		): Accounts {
			return Accounts(role, address, authentication)
		}
	}

	fun editPersonalInfo(newAddress: Address) = this.address.updateTo(newAddress)
}
