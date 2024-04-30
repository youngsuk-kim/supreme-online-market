package io.soboro.supreme.core.model.cart

data class Cart(
    var userId: Long,
    var cartItems: List<CartItem>,
)
