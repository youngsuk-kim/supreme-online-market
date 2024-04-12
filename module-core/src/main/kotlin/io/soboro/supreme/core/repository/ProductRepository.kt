package io.soboro.supreme.core.repository

import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.enums.ProductType

interface ProductRepository {
    fun findAll(type: ProductType): List<Product>
    fun findById(productId: Long): Product?
}

interface CustomProductRepository {
    fun findAll(): List<Product>
}
