package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "product_image")
class ProductImage(
    val url: String,
    val order: Int,
    val description: String,
) : BaseEntity()
