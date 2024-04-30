package io.soboro.supreme.order.core.model.order.repository

import io.soboro.supreme.order.core.model.order.entity.OrderItem

interface OrderItemRepository {
    fun saveAll(items: List<OrderItem>)
}
