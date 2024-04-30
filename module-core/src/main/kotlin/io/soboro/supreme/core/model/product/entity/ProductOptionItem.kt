package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.product.enums.Option
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table

@Entity
@Table(name = "product_option_item")
class ProductOptionItem(
    @Column(nullable = false) var optionName: String,
    @Enumerated(EnumType.STRING) var option: Option,
) : BaseEntity()
