package io.soboro.supreme.core.application

import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.entity.ProductImage
import io.soboro.supreme.core.model.product.entity.ProductItem
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
            items = product.productItems.map(::toItem),
        )
    }

    fun isStockEnough(productId: Long, itemId: Long, quantity: Int): Boolean {
        val product = productRepository.findById(productId)
            ?: throw ProductNotFoundException()

        return product.hasAvailableStock(itemId, quantity)
    }

    private fun toDetailImage(productImage: ProductImage): ProductDetail.DetailImage {
        return ProductDetail.DetailImage(
            url = productImage.url,
            order = productImage.sequence,
            description = productImage.description,
        )
    }

    private fun toItem(productItem: ProductItem): ProductDetail.OptionProduct {
        return ProductDetail.OptionProduct(
            stock = productItem.productUnit.stock,
            option = productItem.productUnit.option,
        )
    }
}
