package io.soboro.supreme.core.api.domain.product.entity

import io.soboro.supreme.core.api.domain.product.enums.Option
import java.time.LocalDateTime

class ProductOption(
    var option: Option,
    private var stock: Int,
    var createdAt: LocalDateTime,
) {
    fun enough(): Boolean {
        return 0 < this.stock
    }
}
