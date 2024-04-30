package io.soboro.supreme.order.core.model.order.repository

import io.soboro.supreme.order.core.model.order.entity.Order

interface OrderRepository {
    fun save(order: Order)
}
