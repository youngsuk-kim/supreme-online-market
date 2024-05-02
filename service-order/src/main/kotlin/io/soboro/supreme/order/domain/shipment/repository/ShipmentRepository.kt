package io.soboro.supreme.order.domain.shipment.repository

import io.soboro.supreme.order.domain.shipment.entity.Shipment

interface ShipmentRepository {
    fun save(shipment: Shipment)
}
