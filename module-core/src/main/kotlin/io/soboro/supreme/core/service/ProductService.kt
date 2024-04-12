package io.soboro.supreme.core.service

import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.enums.ProductType
import io.soboro.supreme.core.model.product.exception.ProductNotFoundException
import io.soboro.supreme.core.model.product.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {
    fun list(type: ProductType): List<Product> {
        return productRepository.findAll(type)
    }

    fun detail(productId: Long): Product {
        val product = productRepository.findById(productId)
            ?: throw ProductNotFoundException()

        return product
    }
}
