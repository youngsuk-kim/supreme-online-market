package io.soboro.supreme.core.model.order.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.common.Money
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class OrderItem(
    @Column(nullable = false) var productName: String,
    @Column(nullable = false) var productCount: Int,
    @Column(nullable = false) var productPrice: Money,
) : BaseEntity()
