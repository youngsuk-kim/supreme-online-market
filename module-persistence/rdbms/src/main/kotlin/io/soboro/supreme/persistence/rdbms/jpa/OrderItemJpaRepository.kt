package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.order.entity.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemJpaRepository : JpaRepository<OrderItem, Long>
