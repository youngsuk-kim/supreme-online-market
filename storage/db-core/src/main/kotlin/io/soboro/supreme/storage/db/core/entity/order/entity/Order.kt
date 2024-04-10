package io.soboro.supreme.storage.db.core.entity.order.entity

import io.soboro.supreme.storage.db.core.entity.BaseEntity
import io.soboro.supreme.storage.db.core.entity.money.Money
import io.soboro.supreme.storage.db.core.entity.order.enums.OrderStatus
import jakarta.persistence.Entity

@Entity
class Order(
    val accountId: Long,
    var status: OrderStatus,
    val orderItems: MutableList<OrderItem>,
): BaseEntity() {
    /**
     * 주문 대기
     *
     * 주문에 필요한 조건들 검증 -> 주문 대기 상태 변경
     */
    fun pending() {
        this.status = OrderStatus.PENDING
    }

    fun totalPrice(): Money {
        return this.orderItems.map { it.totalPrice() }.reduce { acc, money -> acc.plus(money) }
    }
}
