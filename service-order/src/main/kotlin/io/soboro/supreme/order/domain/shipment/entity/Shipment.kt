package io.soboro.supreme.order.domain.shipment.entity

import io.soboro.supreme.order.domain.common.BaseEntity
import io.soboro.supreme.order.domain.order.entity.Order
import io.soboro.supreme.order.domain.shipment.vo.Shipping
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("shipment")
class Shipment(
    @Column var order: Order,
    @Column var shipping: Shipping,
) : BaseEntity()
