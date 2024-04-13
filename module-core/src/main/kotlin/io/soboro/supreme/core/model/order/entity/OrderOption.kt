package io.soboro.supreme.core.model.order.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.product.enums.OptionTitle
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "order_option")
class OrderOption(
    @Column(nullable = false) var orderItemId: Long,
    @Column(nullable = false) var optionName: String,
    @Column(nullable = false) var optionTitle: OptionTitle,
) : BaseEntity()
