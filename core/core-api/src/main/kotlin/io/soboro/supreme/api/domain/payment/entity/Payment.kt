package me.bread.supreme.integration.domain.payment.entity

import me.bread.supreme.integration.domain.money.Money
import me.bread.supreme.integration.domain.order.entity.Order
import me.bread.supreme.integration.domain.payment.vo.PaymentStatus
import java.time.LocalDateTime

class Payment(
	var accountId: Long,
	var totalPrice: Money,
	var status: PaymentStatus,
	var createdAt: LocalDateTime,
	var updatedAt: LocalDateTime,
) {
	fun payed(order: Order) {
		this.accountId = order.accountId
		this.totalPrice = order.totalPrice()
		this.status = PaymentStatus.DONE
	}
}
