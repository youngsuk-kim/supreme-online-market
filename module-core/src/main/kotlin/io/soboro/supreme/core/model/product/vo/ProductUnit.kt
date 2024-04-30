package io.soboro.supreme.core.model.product.vo

import io.soboro.supreme.core.model.product.enums.Option
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.util.UUID

@Embeddable
data class ProductUnit(
    @Column(nullable = false, unique = true) var sku: String = UUID.randomUUID().toString(),
    @Enumerated(EnumType.STRING) var option: Option,
    @Column(nullable = false) var optionName: String,
    @Column(nullable = false) var stock: Int,
)
