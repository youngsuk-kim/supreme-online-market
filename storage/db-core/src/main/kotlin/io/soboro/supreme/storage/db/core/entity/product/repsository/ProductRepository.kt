package io.soboro.supreme.storage.db.core.entity.product.repsository

import io.soboro.supreme.storage.db.core.entity.product.entity.Product
import io.soboro.supreme.storage.db.core.entity.product.enums.ProductType

interface ProductRepository {
    fun findAll(type: ProductType): List<Product>
}
