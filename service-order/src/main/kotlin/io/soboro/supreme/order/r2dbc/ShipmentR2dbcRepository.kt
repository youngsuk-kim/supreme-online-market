package io.soboro.supreme.order.r2dbc

import io.soboro.supreme.order.core.model.shipment.entity.Shipment
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface ShipmentR2dbcRepository : R2dbcRepository<Shipment, Long>
