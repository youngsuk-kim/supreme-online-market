package io.soboro.supreme.core.model.product.repository

import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.enums.ProductType

interface ProductRepository : ProductCustomRepository {
    fun findAll(type: ProductType): List<Product>
    fun saveAll(products: List<Product>)
    fun save(product: Product)
}
