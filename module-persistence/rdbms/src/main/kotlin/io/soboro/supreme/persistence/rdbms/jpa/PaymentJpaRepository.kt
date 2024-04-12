package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.payment.Payment
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentJpaRepository : JpaRepository<Payment, Long>

