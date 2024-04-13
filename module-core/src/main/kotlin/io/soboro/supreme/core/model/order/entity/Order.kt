package io.soboro.supreme.core.model.order.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.order.enums.OrderStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "orders")
class Order(
    @Column(nullable = false) val userId: Long,
    @Enumerated(EnumType.STRING) var status: OrderStatus = OrderStatus.ORDERED,
) : BaseEntity() {
    companion object {
        fun create(userId: Long): Order {
            return Order(
                userId = userId,
                status = OrderStatus.ORDERED,
            )
        }
    }
}
