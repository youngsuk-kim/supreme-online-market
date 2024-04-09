package me.bread.supreme.integration.domain.account.repsository

import me.bread.supreme.integration.domain.account.entity.Accounts

interface AccountsRepository {
	fun save(accounts: Accounts): Accounts
}
