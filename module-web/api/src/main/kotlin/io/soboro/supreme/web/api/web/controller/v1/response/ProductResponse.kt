package io.soboro.supreme.web.api.web.controller.v1.response

import io.soboro.supreme.core.model.product.entity.Product

data class ProductResponse(
    val imageUrl: String,
    val brandName: String,
    val price: String,
    val productName: String,
) {
    companion object {
        fun from(product: Product): ProductResponse {
            return ProductResponse(
                imageUrl = product.images[0].url,
                brandName = product.brandName,
                productName = product.productName,
                price = product.price.toString(),
            )
        }
    }
}
