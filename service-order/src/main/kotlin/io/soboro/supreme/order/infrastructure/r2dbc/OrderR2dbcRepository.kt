package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.order.entity.Order
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface OrderR2dbcRepository : CoroutineCrudRepository<Order, Long>
