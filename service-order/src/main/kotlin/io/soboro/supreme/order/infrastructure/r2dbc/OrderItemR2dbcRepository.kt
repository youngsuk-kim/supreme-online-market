package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.order.entity.OrderItem
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface OrderItemR2dbcRepository : CoroutineCrudRepository<OrderItem, Long>
