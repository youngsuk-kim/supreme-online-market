package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.shipment.entity.Shipment
import io.soboro.supreme.order.domain.shipment.repository.ShipmentRepository
import org.springframework.stereotype.Repository

@Repository
class ShipmentRepositoryAdapter(
    private val shipmentR2dbcRepository: ShipmentR2dbcRepository,
) : ShipmentRepository {
    override suspend fun save(shipment: Shipment) {
        shipmentR2dbcRepository.save(shipment)
    }
}
