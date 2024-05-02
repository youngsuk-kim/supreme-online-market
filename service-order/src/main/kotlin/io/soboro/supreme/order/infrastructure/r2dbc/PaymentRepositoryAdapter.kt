package io.soboro.supreme.order.infrastructure.r2dbc

import io.soboro.supreme.order.domain.payment.repository.PaymentRepository
import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryAdapter(
    private val paymentR2dbcRepository: PaymentR2dbcRepository,
) : PaymentRepository
