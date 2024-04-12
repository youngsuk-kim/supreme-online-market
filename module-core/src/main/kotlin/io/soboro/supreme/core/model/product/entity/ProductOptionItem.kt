package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.product.enums.Option
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne

@Entity
class ProductOptionItem(
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Product::class) var product: Product,
    @Enumerated(EnumType.STRING) var option: Option,
    @Column private var name: String,
    @Column private var stock: Int,
) : BaseEntity() {
    fun enough(): Boolean {
        return 0 < this.stock
    }
}
