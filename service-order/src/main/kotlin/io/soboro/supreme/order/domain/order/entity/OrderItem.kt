package io.soboro.supreme.order.domain.order.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.order.domain.order.vo.Option
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "order_item")
class OrderItem(
    @Column val order: Order,
    @Column var sku: Long,
    @Column var quantity: Long,
    @Column var optionName: String,
    @Column var option: Option,
) : BaseEntity()
