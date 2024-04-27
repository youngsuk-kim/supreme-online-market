package io.soboro.supreme.core.application

import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.entity.ProductImage
import io.soboro.supreme.core.model.product.entity.ProductOptionGroup
import io.soboro.supreme.core.model.product.entity.ProductOptionItem
import io.soboro.supreme.core.model.product.enums.ProductType
import io.soboro.supreme.core.model.product.exception.ProductNotFoundException
import io.soboro.supreme.core.model.product.repository.ProductRepository
import io.soboro.supreme.core.model.product.vo.ProductDetail
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {
    @Transactional(readOnly = true)
    fun list(type: ProductType): List<Product> {
        val findAll = productRepository.findAll(type)
        return findAll
    }

    fun detail(productId: Long): ProductDetail {
        val product = productRepository.findById(productId)
            ?: throw ProductNotFoundException()

        return ProductDetail(
            id = product.id!!,
            productName = product.productName,
            brandName = product.brandName,
            description = product.description,
            detailImages = product.images.map(::toDetailImage),
            optionGroups = product.productOptionGroups.map(::toOptionGroup),
        )
    }

    private fun toDetailImage(productImage: ProductImage): ProductDetail.DetailImage {
        return ProductDetail.DetailImage(
            url = productImage.url,
            order = productImage.sequence,
            description = productImage.description,
        )
    }

    private fun toOptionGroup(productOptionGroup: ProductOptionGroup): ProductDetail.OptionGroup {
        return ProductDetail.OptionGroup(
            stock = productOptionGroup.stock,
            options = productOptionGroup.optionItems.map { productOptionItem ->
                ProductDetail.Option(
                    optionName = productOptionItem.optionName,
                    optionTitle = productOptionItem.optionTitle.name,
                )
            },
        )
    }

    private fun toOption(productOptionItem: ProductOptionItem): ProductDetail.Option {
        return ProductDetail.Option(
            optionName = productOptionItem.optionName,
            optionTitle = productOptionItem.optionTitle.name,
        )
    }
}
