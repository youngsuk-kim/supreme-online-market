package io.soboro.supreme.persistence.rdbms.rdbms.jpa

import io.soboro.supreme.core.model.shipment.entity.Shipment
import io.soboro.supreme.core.model.shipment.repository.ShipmentRepository
import org.springframework.stereotype.Repository

@Repository
class ShipmentRepositoryAdapter(
    private val shipmentJpaRepository: io.soboro.supreme.persistence.rdbms.rdbms.jpa.ShipmentJpaRepository,
) : ShipmentRepository {
    override fun save(shipment: Shipment) {
        shipmentJpaRepository.save(shipment)
    }
}
