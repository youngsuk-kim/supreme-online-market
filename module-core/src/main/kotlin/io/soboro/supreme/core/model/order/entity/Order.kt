package io.soboro.supreme.core.model.order.entity

import io.soboro.supreme.core.model.BaseEntity
import io.soboro.supreme.core.model.order.enums.OrderStatus
import jakarta.persistence.*

@Entity
class Order(
    @Column(nullable = false) val accountId: Long,
    @Enumerated(EnumType.STRING) var status: OrderStatus,
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "order") val items: MutableList<OrderItem>,
) : BaseEntity() {
    fun pending() {
        this.status = OrderStatus.PENDING
    }
}
