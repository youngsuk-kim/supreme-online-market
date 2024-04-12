package io.soboro.supreme.persistence.rdbms.jpa

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.entity.QProduct
import io.soboro.supreme.core.model.product.CustomProductRepository
import io.soboro.supreme.core.service.Products
import org.springframework.stereotype.Repository

@Repository
class CustomProductRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
) : CustomProductRepository {

    fun paginationNoOffsetBuilder(productId: Long?, pageSize: Long): MutableList<Products> {
        val dynamicLtId = BooleanBuilder()

        if (productId != null) {
            dynamicLtId.and(QProduct.product.id.lt(productId))
        }

        return queryFactory
            .select(
                Projections.fields(
                    Products::class.java,
                    QProduct.product.name,
                    QProduct.product.id,
                ),
            )
            .from(QProduct.product)
            .where(dynamicLtId)
            .orderBy(QProduct.product.id.desc())
            .limit(pageSize)
            .fetch()
    }

    override fun findAll(): List<Product> {
        return emptyList()
    }
}