package me.bread.supreme.integration.application.business

import me.bread.supreme.integration.domain.product.entity.Product
import me.bread.supreme.integration.domain.product.enums.ProductType
import me.bread.supreme.integration.domain.product.repsository.ProductRepository

class ProductService(
	private val productRepository: ProductRepository,
) {
	fun list(type: ProductType): List<Product> {
		return productRepository.findAll(type)
	}
}
