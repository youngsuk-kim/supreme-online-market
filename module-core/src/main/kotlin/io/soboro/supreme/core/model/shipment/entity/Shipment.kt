package io.soboro.supreme.core.model.shipment.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.shipment.vo.Shipping
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity

@Entity
class Shipment(
    @Column var orderId: Long,
    @Embedded var shipping: Shipping,
): BaseEntity()