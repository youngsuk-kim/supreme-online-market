package io.soboro.supreme.core.model.payment

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.common.Money
import io.soboro.supreme.core.model.order.entity.Order
import io.soboro.supreme.core.model.payment.vo.PaymentStatus
import jakarta.persistence.Entity

@Entity
class Payment(
    var accountId: Long,
    var totalPrice: Money,
    var status: PaymentStatus,
) : BaseEntity() {
    fun payed(order: Order) {
        this.accountId = order.accountId
//        this.totalPrice = order.totalPrice()
        this.status = PaymentStatus.DONE
    }
}
