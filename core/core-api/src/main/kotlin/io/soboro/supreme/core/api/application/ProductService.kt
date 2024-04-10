package io.soboro.supreme.core.api.application

import io.soboro.supreme.core.api.domain.product.entity.Product
import io.soboro.supreme.core.api.domain.product.enums.ProductType
import io.soboro.supreme.core.api.domain.product.repsository.ProductRepository

class ProductService(
    private val productRepository: ProductRepository,
) {
    fun list(type: ProductType): List<Product> {
        return productRepository.findAll(type)
    }
}
