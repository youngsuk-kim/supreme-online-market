package io.soboro.supreme.order.core.model.shipment.repository

import io.soboro.supreme.order.core.model.shipment.entity.Shipment

interface ShipmentRepository {
    fun save(shipment: Shipment)
}
