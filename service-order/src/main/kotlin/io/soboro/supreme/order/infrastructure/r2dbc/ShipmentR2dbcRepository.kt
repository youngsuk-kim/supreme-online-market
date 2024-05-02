package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.shipment.entity.Shipment
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ShipmentR2dbcRepository : CoroutineCrudRepository<Shipment, Long>
