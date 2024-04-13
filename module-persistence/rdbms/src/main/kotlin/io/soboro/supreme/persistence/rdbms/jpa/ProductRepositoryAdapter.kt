package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.enums.ProductType
import io.soboro.supreme.core.model.product.repository.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryAdapter(
    private val productJpaRepository: ProductJpaRepository,
) : ProductRepository {
    override fun findAll(type: ProductType): List<Product> {
        return productJpaRepository.findAll()
    }

    override fun findById(productId: Long): Product? {
        return productJpaRepository.findByIdOrNull(productId)
    }
}