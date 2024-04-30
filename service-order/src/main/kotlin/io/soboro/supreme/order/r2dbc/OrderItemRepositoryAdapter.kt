package io.soboro.supreme.order.r2dbc

import io.soboro.supreme.order.core.model.order.entity.OrderItem
import io.soboro.supreme.order.core.model.order.repository.OrderItemRepository
import org.springframework.stereotype.Repository

@Repository
class OrderItemRepositoryAdapter(
    private val orderItemR2dbcRepository: OrderItemR2dbcRepository,
) : OrderItemRepository {
    override fun saveAll(items: List<OrderItem>) {
        orderItemR2dbcRepository.saveAll(items)
    }
}
