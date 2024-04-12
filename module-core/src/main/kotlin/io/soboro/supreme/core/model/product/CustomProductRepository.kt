package io.soboro.supreme.core.model.product

import io.soboro.supreme.core.model.product.entity.Product

interface CustomProductRepository {
    fun findAll(): List<Product>
}