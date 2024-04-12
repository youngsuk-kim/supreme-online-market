package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.order.OrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryAdapter(
    private val orderJpaRepository: OrderJpaRepository,
) : OrderRepository