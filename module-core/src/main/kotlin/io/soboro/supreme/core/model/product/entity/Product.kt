package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.common.Money
import io.soboro.supreme.core.model.product.enums.ProductType
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.OneToOne
import java.time.LocalDateTime

@Entity
class Product(
    @Column var name: String,
    @Column var brandName: String,
    @Column var description: String,
    @Embedded var price: Money,
    @OneToOne var timeLimit: TimeLimit,
    @Enumerated(EnumType.STRING) var type: ProductType,
) : BaseEntity() {
    fun canBuy(now: LocalDateTime = LocalDateTime.now()): Boolean {
        // 구매 마감 시간 지났는지
        if (this.timeLimit.timeOver(now)) return false

        return true
    }

    fun price(): Money {
        return this.price
    }
}
