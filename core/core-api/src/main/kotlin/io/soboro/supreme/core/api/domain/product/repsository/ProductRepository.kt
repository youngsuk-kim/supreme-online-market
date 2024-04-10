package io.soboro.supreme.core.api.domain.product.repsository

import io.soboro.supreme.core.api.domain.product.entity.Product
import io.soboro.supreme.core.api.domain.product.enums.ProductType

interface ProductRepository {
    fun findAll(type: ProductType): List<Product>
}
