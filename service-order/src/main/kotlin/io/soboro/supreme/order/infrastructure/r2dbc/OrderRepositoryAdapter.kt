package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.order.entity.Order
import io.soboro.supreme.order.domain.order.repository.OrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryAdapter(
    private val orderR2dbcRepository: OrderR2dbcRepository,
) : OrderRepository {
    override suspend fun save(order: Order) {
        orderR2dbcRepository.save(order)
    }
}
