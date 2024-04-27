package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "product_option_group")
class ProductOptionGroup(
    @ManyToOne(fetch = FetchType.LAZY) var product: Product?,
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY) var optionItems: List<ProductOptionItem>,
    @Column val stock: Int,
) : BaseEntity()
