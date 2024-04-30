package io.soboro.supreme.order.r2dbc

import io.soboro.supreme.order.core.model.payment.repository.PaymentRepository
import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryAdapter(
    private val paymentR2dbcRepository: PaymentR2dbcRepository,
) : PaymentRepository
