package io.soboro.supreme.persistence.rdbms.rdbms.jpa

import io.soboro.supreme.core.model.payment.repository.PaymentRepository
import org.springframework.stereotype.Repository

@Repository
class PaymentRepositoryAdapter(
    private val paymentJpaRepository: io.soboro.supreme.persistence.rdbms.rdbms.jpa.PaymentJpaRepository,
) : PaymentRepository
