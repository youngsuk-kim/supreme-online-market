package me.bread.supreme.integration.domain.product.repsository

import me.bread.supreme.integration.domain.product.entity.Product
import me.bread.supreme.integration.domain.product.enums.ProductType

interface ProductRepository {
	fun findAll(type: ProductType): List<Product>
}
