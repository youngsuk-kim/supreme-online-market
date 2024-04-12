package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.payment.PaymentRepository
import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryAdapter(
    private val paymentJpaRepository: PaymentJpaRepository,
) : PaymentRepository