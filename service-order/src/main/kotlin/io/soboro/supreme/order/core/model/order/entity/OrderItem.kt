package io.soboro.supreme.order.core.model.order.entity

import io.soboro.supreme.order.core.model.order.vo.Option
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "order_item")
class OrderItem(
    @Column val order: Order,
    @Column var sku: String,
    @Column var quantity: Int,
    @Column var optionName: String,
    @Column var option: Option,
)
