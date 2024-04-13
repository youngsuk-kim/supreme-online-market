package io.soboro.supreme.core.model.order.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.product.enums.Option
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class OrderOption(
    @Column(nullable = false) var orderItemId: Long,
    @Column(nullable = false) var optionName: String,
    @Column(nullable = false) var option: Option,
): BaseEntity()