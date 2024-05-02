package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.order.entity.OrderItem
import io.soboro.supreme.order.domain.order.repository.OrderItemRepository
import org.springframework.stereotype.Repository

@Repository
class OrderItemRepositoryAdapter(
    private val orderItemR2dbcRepository: OrderItemR2dbcRepository,
) : OrderItemRepository {
    override suspend fun save(item: OrderItem) {
        orderItemR2dbcRepository.save(item)
    }
}
