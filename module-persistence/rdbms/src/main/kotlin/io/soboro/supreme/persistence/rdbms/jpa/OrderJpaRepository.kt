package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.order.entity.Order
import io.soboro.supreme.core.repository.CartRepository
import io.soboro.supreme.core.repository.OrderRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface OrderJpaRepository : JpaRepository<Order, Long>

@Repository
class OrderRepositoryAdapter(
    private val orderJpaRepository: OrderJpaRepository
): OrderRepository
