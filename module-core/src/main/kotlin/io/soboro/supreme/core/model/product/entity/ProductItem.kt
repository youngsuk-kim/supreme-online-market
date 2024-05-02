package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.product.vo.ProductUnit
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "product_item")
class ProductItem(
    @Embedded var productUnit: ProductUnit,
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "product_id") var product: Product,
) : BaseEntity() {

    fun hasEnough(quantity: Long) = this.productUnit.stock > quantity
}
