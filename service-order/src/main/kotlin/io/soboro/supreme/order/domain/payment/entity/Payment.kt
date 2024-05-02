package io.soboro.supreme.order.domain.payment.entity

import io.soboro.supreme.order.domain.common.BaseEntity
import io.soboro.supreme.order.domain.common.Money
import io.soboro.supreme.order.domain.order.entity.Order
import io.soboro.supreme.order.domain.payment.vo.PaymentStatus
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "payments")
class Payment(
    @Id var id: Long? = null,
    private var accountId: Long,
    var totalPrice: Money,
    private var status: PaymentStatus,
) : BaseEntity() {
    fun payed(order: Order) {
        this.accountId = order.userId
        this.status = PaymentStatus.DONE
    }
}
