package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.shipment.Shipment
import org.springframework.data.jpa.repository.JpaRepository

interface ShipmentJpaRepository: JpaRepository<Shipment, Long>

