package io.soboro.supreme.persistence.rdbms.rdbms.jpa

import io.soboro.supreme.core.model.order.entity.OrderItem
import io.soboro.supreme.core.model.order.repository.OrderItemRepository
import org.springframework.stereotype.Repository

@Repository
class OrderItemRepositoryAdapter(
    private val orderItemJpaRepository: io.soboro.supreme.persistence.rdbms.rdbms.jpa.OrderItemJpaRepository,
) : OrderItemRepository {
    override fun saveAll(items: List<OrderItem>) {
        orderItemJpaRepository.saveAll(items)
    }
}
