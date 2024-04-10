package io.soboro.supreme.core.model.order.entity

import io.soboro.supreme.core.model.BaseEntity
import jakarta.persistence.*

@Entity
class OrderItem(
    @Column(nullable = false) var productId: Long,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "order", nullable = false) var order: Order,
) : BaseEntity()
