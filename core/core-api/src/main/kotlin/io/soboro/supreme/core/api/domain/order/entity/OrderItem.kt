package io.soboro.supreme.core.api.domain.order.entity

import io.soboro.supreme.core.api.domain.money.Money
import io.soboro.supreme.core.api.domain.product.entity.Product

class OrderItem(
    var products: List<Product>,
) {
    fun totalPrice(): Money {
        return this.products.map { it.price() }
            .reduce { acc, money -> acc.plus(money) }
    }
}
