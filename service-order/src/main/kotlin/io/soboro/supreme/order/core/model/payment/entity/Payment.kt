package io.soboro.supreme.order.core.model.payment.entity

import io.soboro.supreme.order.core.model.common.Money
import io.soboro.supreme.order.core.model.order.entity.Order
import io.soboro.supreme.order.core.model.payment.vo.PaymentStatus
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "payments")
class Payment(
    @Id var id: Long? = null,
    private var accountId: Long,
    var totalPrice: Money,
    private var status: PaymentStatus,
) {
    fun payed(order: Order) {
        this.accountId = order.userId
        this.status = PaymentStatus.DONE
    }
}
