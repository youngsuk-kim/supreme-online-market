package io.soboro.supreme.web.api.web.controller.v1.response

import io.soboro.supreme.core.model.product.entity.Product

data class ProductDetailResponse(
    val id: Long,
    val name: String,
    val description: String,
    val price: String,
) {
    companion object {
        // FIXME
        fun from(product: Product) = ProductDetailResponse(product.id!!, product.productName, product.description, product.toString())
    }
}
