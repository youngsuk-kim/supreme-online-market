package me.bread.supreme.integration.domain.money

import java.math.BigDecimal

data class Money(private val amount: BigDecimal) {
	companion object {
		val ZERO = won(0)

		fun won(amount: Long) = Money(BigDecimal.valueOf(amount))

		fun won(amount: Double) = Money(BigDecimal.valueOf(amount))

		fun <T> sum(
			bags: Collection<T>,
			monetary: (T) -> Money,
		) = bags.map { bag -> monetary.invoke(bag) }.reduce { acc, money -> acc.plus(money) }
	}

	fun plus(amount: Money) = Money(this.amount.add(amount.amount))

	fun minus(amount: Money) = Money(this.amount.subtract(amount.amount))

	fun times(percent: Double) = Money(this.amount.multiply(BigDecimal.valueOf(percent)))

	fun divide(divisor: Double) = Money(amount.divide(BigDecimal.valueOf(divisor)))

	fun isLessThan(other: Money) = amount.compareTo(other.amount) < 0

	fun isGreaterThanOrEqual(other: Money) = amount.compareTo(other.amount) >= 0

	fun getAmount() = amount

	fun longValue() = amount.toLong()

	fun doubleValue() = amount.toDouble()

	override fun toString() = "${amount}원"
}
