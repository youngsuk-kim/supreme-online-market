package io.soboro.supreme.core.model.shipment.repository

import io.soboro.supreme.core.model.shipment.entity.Shipment

interface ShipmentRepository {
    fun save(shipment: Shipment)
}