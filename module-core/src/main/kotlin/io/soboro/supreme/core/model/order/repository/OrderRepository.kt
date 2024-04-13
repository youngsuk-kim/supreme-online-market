package io.soboro.supreme.core.model.order.repository

import io.soboro.supreme.core.model.order.entity.Order

interface OrderRepository {
    fun save(order: Order)
}
