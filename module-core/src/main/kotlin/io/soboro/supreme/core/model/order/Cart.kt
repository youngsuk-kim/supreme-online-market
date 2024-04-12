package io.soboro.supreme.core.model.order

import io.soboro.supreme.core.model.product.enums.Option
import java.math.BigDecimal

data class Cart(
    var userId: Long,
    var cartItems: List<CartOptionItem>,
) {

    data class CartOptionItem(
        val name: String,
        val option: Option,
        val count: Int,
        val price: BigDecimal
    )
}

