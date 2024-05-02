package io.soboro.supreme.order.domain.order.repository

import io.soboro.supreme.order.domain.order.entity.OrderItem

interface OrderItemRepository {
    suspend fun save(item: OrderItem)
}
