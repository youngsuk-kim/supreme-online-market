package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.order.entity.OrderItem
import io.soboro.supreme.order.domain.order.repository.OrderItemRepository
import org.springframework.stereotype.Repository

@Repository
class OrderItemRepositoryAdapter(
    private val orderItemR2dbcRepository: OrderItemR2dbcRepository,
) : OrderItemRepository {
    override fun saveAll(items: List<OrderItem>) {
        orderItemR2dbcRepository.saveAll(items)
    }
}
