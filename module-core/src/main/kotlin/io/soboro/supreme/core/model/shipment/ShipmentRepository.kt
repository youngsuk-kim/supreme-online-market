package io.soboro.supreme.core.model.shipment

interface ShipmentRepository {
    fun save(shipment: Shipment)
}