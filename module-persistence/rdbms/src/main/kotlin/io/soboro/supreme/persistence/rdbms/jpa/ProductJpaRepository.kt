package io.soboro.supreme.persistence.rdbms.jpa

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.entity.QProduct.product
import io.soboro.supreme.core.model.product.enums.ProductType
import io.soboro.supreme.core.repository.CustomProductRepository
import io.soboro.supreme.core.repository.ProductRepository
import io.soboro.supreme.core.service.Products
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository


interface ProductJpaRepository : JpaRepository<Product, Long>, CustomProductRepository

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

@Repository
class CustomProductRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
) : CustomProductRepository {

    fun paginationNoOffsetBuilder(productId: Long?, pageSize: Long): MutableList<Products> {
        val dynamicLtId = BooleanBuilder()

        if (productId != null) {
            dynamicLtId.and(product.id.lt(productId))
        }

        return queryFactory
            .select(
                Projections.fields(
                    Products::class.java,
                    product.name,
                    product.id,
                ),
            )
            .from(product)
            .where(dynamicLtId)
            .orderBy(product.id.desc())
            .limit(pageSize)
            .fetch()
    }

    override fun findAll(): List<Product> {
        return emptyList()
    }
}


