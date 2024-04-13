package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class Product(
    @OneToMany(cascade = [CascadeType.ALL]) var productOptionGroups: List<ProductOptionGroup>,
    @OneToMany(cascade = [CascadeType.ALL]) var images: List<ProductImage>,
    @OneToOne var productTimeLimit: ProductTimeLimit,
    @Column var productName: String,
    @Column var brandName: String,
    @Column var description: String,
) : BaseEntity()
