package io.soboro.supreme.storage.db.core.entity.product.entity

import io.soboro.supreme.storage.db.core.entity.BaseEntity
import io.soboro.supreme.storage.db.core.entity.product.enums.Option
import jakarta.persistence.Entity

@Entity
class ProductOption(
    var option: Option,
    private var stock: Int,
): BaseEntity() {
    fun enough(): Boolean {
        return 0 < this.stock
    }
}
