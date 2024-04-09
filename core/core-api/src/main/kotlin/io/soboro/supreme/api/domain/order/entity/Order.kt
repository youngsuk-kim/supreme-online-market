package me.bread.supreme.integration.domain.order.entity

import me.bread.supreme.integration.domain.money.Money
import me.bread.supreme.integration.domain.order.enums.OrderStatus

class Order(
	val accountId: Long,
	var status: OrderStatus,
	val orderItems: MutableList<OrderItem>,
) {
	/**
	 * 주문 대기
	 *
	 * 주문에 필요한 조건들 검증 -> 주문 대기 상태 변경
	 */
	fun pending() {
		this.status = OrderStatus.PENDING
	}

	fun totalPrice(): Money {
		return this.orderItems.map { it.totalPrice() }.reduce { acc, money -> acc.plus(money) }
	}
}
