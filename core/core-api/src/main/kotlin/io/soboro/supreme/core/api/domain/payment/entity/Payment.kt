package io.soboro.supreme.core.api.domain.payment.entity

import io.soboro.supreme.core.api.domain.money.Money
import io.soboro.supreme.core.api.domain.payment.vo.PaymentStatus
import io.soboro.supreme.core.api.domain.order.entity.Order
import java.time.LocalDateTime

class Payment(
    var accountId: Long,
    var totalPrice: Money,
    var status: PaymentStatus,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
) {
    fun payed(order: Order) {
        this.accountId = order.accountId
        this.totalPrice = order.totalPrice()
        this.status = PaymentStatus.DONE
    }
}
