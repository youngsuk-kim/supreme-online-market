package io.soboro.supreme.core.application

import io.soboro.supreme.core.model.cart.Cart
import io.soboro.supreme.core.model.cart.ProductUnit
import io.soboro.supreme.core.model.product.repository.CartRepository
import org.springframework.stereotype.Service

@Service
class CartService(
    private val cartRepository: CartRepository,
) {

    fun add(userId: Long, productUnit: ProductUnit) {
        cartRepository.add(userId, productUnit)
    }

    fun remove(userId: Long, productUnit: ProductUnit) {
        cartRepository.remove(userId, productUnit)
    }

    fun clear(userId: Long) {
        cartRepository.clear(userId)
    }

    fun get(userId: Long): Cart {
        return cartRepository.get(userId)
    }
}
