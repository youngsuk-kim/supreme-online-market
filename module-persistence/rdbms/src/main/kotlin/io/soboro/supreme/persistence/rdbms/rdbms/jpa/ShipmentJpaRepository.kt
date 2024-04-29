package io.soboro.supreme.persistence.rdbms.rdbms.jpa

import io.soboro.supreme.core.model.shipment.entity.Shipment
import org.springframework.data.jpa.repository.JpaRepository

interface ShipmentJpaRepository : JpaRepository<Shipment, Long>
