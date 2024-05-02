package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.payment.entity.Payment
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface PaymentR2dbcRepository : R2dbcRepository<Payment, Long>
