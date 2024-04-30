package io.soboro.supreme.core.model.product.repository

import io.soboro.supreme.core.model.cart.Cart
import io.soboro.supreme.core.model.cart.ProductUnit

interface CartRepository {
    fun add(userId: Long, productUnit: ProductUnit)
    fun remove(userId: Long, productUnit: ProductUnit)
    fun clear(userId: Long)
    fun get(userId: Long): Cart
}
