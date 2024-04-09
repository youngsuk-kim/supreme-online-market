package me.bread.supreme.integration.domain.cart

import me.bread.supreme.integration.domain.product.entity.Product

class CartItem(
	var product: MutableList<Product>
) {
	fun add(product: Product) {
		this.product += product
	}

	fun remove(product: Product) {
		this.product -= product
	}
}
