package io.soboro.supreme.core.model.order

import io.soboro.supreme.core.model.order.entity.Order

interface OrderRepository {
    fun save(order: Order)
}
