package io.soboro.supreme.core.api.application

import io.soboro.supreme.storage.db.core.entity.product.entity.Product
import io.soboro.supreme.storage.db.core.entity.product.enums.ProductType
import io.soboro.supreme.storage.db.core.entity.product.repsository.ProductRepository

class ProductService(
    private val productRepository: ProductRepository,
) {
    fun list(type: ProductType): List<Product> {
        return productRepository.findAll(type)
    }
}
