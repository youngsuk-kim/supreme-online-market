package io.soboro.supreme.order.r2dbc

import io.soboro.supreme.order.core.model.order.entity.OrderItem
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface OrderItemR2dbcRepository : R2dbcRepository<OrderItem, Long>
