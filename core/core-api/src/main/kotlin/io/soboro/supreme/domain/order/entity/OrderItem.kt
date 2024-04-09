package me.bread.supreme.integration.domain.order.entity

import me.bread.supreme.integration.domain.money.Money
import me.bread.supreme.integration.domain.product.entity.Product

class OrderItem(
	var products: List<Product>,
) {
	fun totalPrice(): Money {
		return this.products.map { it.price() }
			.reduce { acc, money -> acc.plus(money) }
	}
}
