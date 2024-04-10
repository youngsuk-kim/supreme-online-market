package io.soboro.supreme.core.api.domain.cart

import io.soboro.supreme.core.api.domain.product.entity.Product

class CartItem(
    var product: MutableList<Product>,
) {
    fun add(product: Product) {
        this.product += product
    }

    fun remove(product: Product) {
        this.product -= product
    }
}
