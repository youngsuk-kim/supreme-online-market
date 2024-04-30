package io.soboro.supreme.order.core.model.shipment.entity

import io.soboro.supreme.order.core.model.shipment.vo.Shipping
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("shipment")
class Shipment(
    @Column var orderId: Long,
    @Column var shipping: Shipping,
)
