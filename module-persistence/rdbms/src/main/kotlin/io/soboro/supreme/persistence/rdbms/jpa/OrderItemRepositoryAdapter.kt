package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.order.repository.OrderItemRepository
import io.soboro.supreme.core.model.order.entity.OrderItem
import org.springframework.stereotype.Repository

@Repository
class OrderItemRepositoryAdapter(
    private val orderItemJpaRepository: OrderItemJpaRepository
): OrderItemRepository {
    override fun saveAll(items: List<OrderItem>) {
        orderItemJpaRepository.saveAll(items)
    }
}