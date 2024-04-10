package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.payment.Payment
import io.soboro.supreme.core.repository.OrderRepository
import io.soboro.supreme.core.repository.PaymentRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface PaymentJpaRepository : JpaRepository<Payment, Long>

@Repository
class PaymentRepositoryAdapter(
    private val paymentJpaRepository: PaymentJpaRepository
): PaymentRepository