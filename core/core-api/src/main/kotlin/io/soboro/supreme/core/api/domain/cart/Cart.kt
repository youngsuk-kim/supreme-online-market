package io.soboro.supreme.core.api.domain.cart

class Cart(
    var cartItems: MutableList<CartItem>,
) {
    fun put(cartItem: CartItem) {
        this.cartItems.add(cartItem)
    }

    fun modify(cartItem: CartItem) {
        this.cartItems.remove(cartItem)
        this.cartItems.add(cartItem)
    }
}
