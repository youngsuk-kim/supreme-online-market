package me.bread.supreme.integration.domain.cart

class Cart(
	var cartItems: MutableList<CartItem>
) {
	fun put(cartItem: CartItem) {
		this.cartItems.add(cartItem)
	}

	fun modify(cartItem: CartItem) {
		this.cartItems.remove(cartItem)
		this.cartItems.add(cartItem)
	}
}
