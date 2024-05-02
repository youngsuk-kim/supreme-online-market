package io.soboro.supreme.order.domain.order.entity

import io.soboro.supreme.order.domain.common.BaseEntity
import io.soboro.supreme.order.domain.order.enums.OrderStatus
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "orders")
class Order(
    @Id var id: Long? = null,
    @Column val userId: Long,
    @Column var status: OrderStatus = OrderStatus.PLACED,
) : BaseEntity() {
    companion object {
        fun create(userId: Long): Order {
            return Order(
                userId = userId,
                status = OrderStatus.PLACED,
            )
        }
    }
}
