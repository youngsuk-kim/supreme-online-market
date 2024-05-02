package io.soboro.supreme.order.domain.shipment.repository

import io.soboro.supreme.order.domain.shipment.entity.Shipment

interface ShipmentRepository {
    suspend fun save(shipment: Shipment)
}
