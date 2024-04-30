package io.soboro.supreme.core.application

import io.soboro.supreme.core.model.cart.Cart
import io.soboro.supreme.core.model.cart.CartItem
import io.soboro.supreme.core.model.product.repository.CartRepository
import org.springframework.stereotype.Service

@Service
class CartService(
    private val cartRepository: CartRepository,
) {

    fun add(userId: Long, cartItem: CartItem) {
        cartRepository.add(userId, cartItem)
    }

    fun remove(userId: Long, cartItem: CartItem) {
        cartRepository.add(userId, cartItem)
    }

    fun clear(userId: Long) {
        cartRepository.clear(userId)
    }

    fun get(userId: Long): Cart {
        return cartRepository.get(userId)
    }
}
