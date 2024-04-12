package io.soboro.supreme.core.model.order.entity

import io.soboro.supreme.core.model.BaseEntity
import io.soboro.supreme.core.model.order.enums.OrderStatus
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "orders")
class Order(
    @Column(nullable = false) val accountId: Long,
    @Enumerated(EnumType.STRING) var status: OrderStatus,
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "order") val items: MutableList<OrderItem>,
) : BaseEntity() {
    fun pending() {
        this.status = OrderStatus.PENDING
    }
}
