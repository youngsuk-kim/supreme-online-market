package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Lob
import jakarta.persistence.Table

@Entity
@Table(name = "product_image")
class ProductImage(
    @Lob
    val url: String,
    val sequence: Int,
    val description: String,
) : BaseEntity()
