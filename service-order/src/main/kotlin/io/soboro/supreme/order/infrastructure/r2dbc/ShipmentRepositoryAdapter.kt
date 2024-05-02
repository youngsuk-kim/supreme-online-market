package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.shipment.entity.Shipment
import io.soboro.supreme.order.domain.shipment.repository.ShipmentRepository
import org.springframework.stereotype.Repository

@Repository
class ShipmentRepositoryAdapter(
    private val shipmentJpaRepository: ShipmentR2dbcRepository,
) : ShipmentRepository {
    override fun save(shipment: Shipment) {
        shipmentJpaRepository.save(shipment)
    }
}
