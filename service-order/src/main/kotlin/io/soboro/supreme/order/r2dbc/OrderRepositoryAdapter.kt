package io.soboro.supreme.order.r2dbc

import io.soboro.supreme.order.core.model.order.entity.Order
import io.soboro.supreme.order.core.model.order.repository.OrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryAdapter(
    private val orderR2dbcRepository: OrderR2dbcRepository,
) : OrderRepository {
    override fun save(order: Order) {
        orderR2dbcRepository.save(order)
    }
}
