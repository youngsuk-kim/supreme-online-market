package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.shipment.Shipment
import io.soboro.supreme.core.model.shipment.ShipmentRepository
import org.springframework.stereotype.Repository

@Repository
class ShipmentRepositoryAdapter(
    private val shipmentJpaRepository: ShipmentJpaRepository
): ShipmentRepository {
    override fun save(shipment: Shipment) {
        shipmentJpaRepository.save(shipment)
    }
}