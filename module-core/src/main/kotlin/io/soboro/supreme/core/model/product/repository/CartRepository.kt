package io.soboro.supreme.core.model.product.repository

import io.soboro.supreme.core.model.cart.Cart
import io.soboro.supreme.core.model.cart.CartItem

interface CartRepository {
    fun add(userId: Long, cartItem: CartItem)
    fun remove(userId: Long, cartItem: CartItem)
    fun clear(userId: Long)
    fun get(userId: Long): Cart
}
