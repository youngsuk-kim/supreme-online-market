package io.soboro.supreme.core.model.cart

import io.soboro.supreme.core.model.product.enums.Option
import java.math.BigDecimal

data class CartItem(
    val optionName: String,
    val option: Option,
    val productName: String,
    val price: BigDecimal,
    val count: Int,
)
