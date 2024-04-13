package io.soboro.supreme.core.model.order

import io.soboro.supreme.core.model.order.entity.OrderItem

interface OrderItemRepository {
    fun saveAll(items: List<OrderItem>)
}