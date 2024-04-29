package io.soboro.supreme.persistence.rdbms.rdbms.jpa

import io.soboro.supreme.core.model.order.entity.Order
import io.soboro.supreme.core.model.order.repository.OrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryAdapter(
    private val orderJpaRepository: io.soboro.supreme.persistence.rdbms.rdbms.jpa.OrderJpaRepository,
) : OrderRepository {
    override fun save(order: Order) {
        orderJpaRepository.save(order)
    }
}
