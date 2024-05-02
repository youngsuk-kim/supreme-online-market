package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.shipment.entity.Shipment
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface ShipmentR2dbcRepository : R2dbcRepository<Shipment, Long>
