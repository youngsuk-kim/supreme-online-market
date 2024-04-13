package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.order.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderJpaRepository : JpaRepository<Order, Long>
