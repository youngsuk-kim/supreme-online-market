package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.common.Money
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "product")
class Product(
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY) @JoinColumn(name = "product") var productOptionGroups: MutableList<ProductOptionGroup>,
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY) var images: List<ProductImage>,
    @Column var productName: String,
    @Column var brandName: String,
    @Column var description: String,
    @Column var price: Money,
) : BaseEntity()
