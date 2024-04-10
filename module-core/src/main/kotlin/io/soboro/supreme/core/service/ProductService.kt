package io.soboro.supreme.core.service

import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.enums.ProductType
import io.soboro.supreme.core.repository.ProductRepository

class ProductService(
    private val productRepository: ProductRepository,
) {
    fun list(type: ProductType): List<Product> {
        return productRepository.findAll(type)
    }
}
