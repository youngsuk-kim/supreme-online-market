package io.soboro.supreme.order.domain.order.entity

import io.soboro.supreme.order.domain.common.BaseEntity
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "order_item")
class OrderItem(
    @Id var id: Long? = null,
    @Column var sku: Long,
    @Column val orderId: Long,
    @Column var quantity: Long,
    @Column var optionValue: String,
    @Column var optionKey: String,
) : BaseEntity()
