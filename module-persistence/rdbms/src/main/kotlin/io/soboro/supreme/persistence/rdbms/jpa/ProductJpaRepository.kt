package io.soboro.supreme.persistence.rdbms.jpa

import com.querydsl.jpa.impl.JPAQueryFactory
import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.enums.ProductType
import io.soboro.supreme.core.repository.ProductRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface ProductJpaRepository : JpaRepository<Product, Long>, CustomProductRepository

@Repository
class ProductRepositoryAdapter(
    private val productJpaRepository: ProductJpaRepository,
) : ProductRepository {
    override fun findAll(type: ProductType): List<Product> {
        return productJpaRepository.findAll()
    }
}

@Repository
class CustomProductRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : CustomProductRepository {

    override fun findAll(): List<Product> {
        return emptyList()
    }
}

interface CustomProductRepository {
    fun findAll(): List<Product>
}
