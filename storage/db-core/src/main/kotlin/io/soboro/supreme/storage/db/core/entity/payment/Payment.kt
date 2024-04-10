package io.soboro.supreme.storage.db.core.entity.payment

import io.soboro.supreme.storage.db.core.entity.money.Money
import io.soboro.supreme.storage.db.core.entity.payment.vo.PaymentStatus
import io.soboro.supreme.storage.db.core.entity.order.entity.Order
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
