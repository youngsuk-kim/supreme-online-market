package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.product.enums.OptionTitle
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "product_option_item")
class ProductOptionItem(
    @ManyToOne(fetch = FetchType.LAZY) val productOptionGroup: ProductOptionGroup,
    @Column(nullable = false) var optionName: String,
    @Enumerated(EnumType.STRING) var optionTitle: OptionTitle
): BaseEntity()