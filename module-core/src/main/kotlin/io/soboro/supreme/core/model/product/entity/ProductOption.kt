package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.BaseEntity
import io.soboro.supreme.core.model.product.enums.Option
import jakarta.persistence.Entity

@Entity
class ProductOption(
    var option: Option,
    private var stock: Int,
) : BaseEntity() {
    fun enough(): Boolean {
        return 0 < this.stock
    }
}
