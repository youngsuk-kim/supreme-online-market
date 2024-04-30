package io.soboro.supreme.order.r2dbc

import io.soboro.supreme.order.core.model.order.entity.Order
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface OrderR2dbcRepository : R2dbcRepository<Order, Long>
