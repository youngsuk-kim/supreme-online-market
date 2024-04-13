package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.order.repository.OrderRepository
import io.soboro.supreme.core.model.order.entity.Order
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryAdapter(
    private val orderJpaRepository: OrderJpaRepository,
) : OrderRepository {
    override fun save(order: Order) {
        orderJpaRepository.save(order)
    }
}