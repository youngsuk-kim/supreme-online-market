package io.soboro.supreme.core.model.order.entity

import io.soboro.supreme.core.model.common.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "order_item")
class OrderItem(
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Order::class) val order: Order,
    @Column(nullable = false) var productName: String,
    @Column(nullable = false) var productCount: Int,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL]) val orderOption: List<OrderOption>,
) : BaseEntity()
