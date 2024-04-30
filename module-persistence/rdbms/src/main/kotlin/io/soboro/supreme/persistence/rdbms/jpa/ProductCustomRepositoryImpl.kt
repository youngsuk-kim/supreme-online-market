package io.soboro.supreme.persistence.rdbms.jpa

import com.querydsl.jpa.impl.JPAQueryFactory
import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.entity.QProduct.product
import io.soboro.supreme.core.model.product.entity.QProductImage.productImage
import io.soboro.supreme.core.model.product.entity.QProductOptionGroup.productOptionGroup
import io.soboro.supreme.core.model.product.repository.ProductCustomRepository
import org.springframework.stereotype.Repository

@Repository
class ProductCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
) : ProductCustomRepository {

    override fun findById(productId: Long): Product? {
        return queryFactory
            .selectFrom(product)
            .where(product.id.eq(productId))
            .leftJoin(product.productOptionGroups, productOptionGroup)
            .leftJoin(product.images, productImage)
            .fetchJoin()
            .fetchOne()
    }
}
