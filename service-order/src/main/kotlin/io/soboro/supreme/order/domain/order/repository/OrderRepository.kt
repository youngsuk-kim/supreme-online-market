package io.soboro.supreme.order.domain.order.repository

import io.soboro.supreme.order.domain.order.entity.Order

interface OrderRepository {
    suspend fun save(order: Order)
}
