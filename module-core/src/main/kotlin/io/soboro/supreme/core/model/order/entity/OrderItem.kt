package io.soboro.supreme.core.model.order.entity

import io.soboro.supreme.core.model.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne

@Entity
class OrderItem(
    @Column(nullable = false) var productId: Long,
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Order::class) var order: Order,
) : BaseEntity()
