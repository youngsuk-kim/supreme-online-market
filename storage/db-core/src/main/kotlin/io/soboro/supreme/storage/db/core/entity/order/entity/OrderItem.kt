package io.soboro.supreme.storage.db.core.entity.order.entity

import io.soboro.supreme.storage.db.core.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class OrderItem(
    @Column(nullable = false) var productId: Long,
): BaseEntity() {
//    fun totalPrice(): Money {
//        return this.products.map { it.price() }
//            .reduce { acc, money -> acc.plus(money) }
//    }
}
