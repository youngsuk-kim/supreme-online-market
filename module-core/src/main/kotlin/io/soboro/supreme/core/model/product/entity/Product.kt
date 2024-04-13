package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class Product(
    @Column var productName: String,
    @Column var brandName: String,
    @Column var description: String,
    @OneToOne var productTimeLimit: ProductTimeLimit,
) : BaseEntity()
