package io.soboro.supreme.core.model.order.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.product.enums.Option
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "order_item")
class OrderItem(
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Order::class) val order: Order,
    @Column(nullable = false) var sku: String,
    @Column(nullable = false) var quantity: Int,
    @Column(nullable = false) var optionName: String,
    @Column(nullable = false) var option: Option,
) : BaseEntity()
