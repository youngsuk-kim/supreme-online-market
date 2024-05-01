package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.common.Money
import io.soboro.supreme.core.model.product.exception.ProductNotFoundException
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "products")
class Product(
    @OneToMany(
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
    ) @JoinColumn(name = "product") var productItems: MutableList<ProductItem>,
    @OneToMany(
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
    ) @JoinColumn(name = "product") var images: List<ProductImage>,
    @Column var productName: String,
    @Column var brandName: String,
    @Column var description: String,
    @Column var price: Money,
) : BaseEntity() {

    fun hasAvailableStock(itemId: Long, quantity: Int): Boolean {
        val productItem = (this.productItems.find { item -> item.id == itemId }
            ?: throw ProductNotFoundException())

        return productItem.hasEnough(quantity)
    }
}
