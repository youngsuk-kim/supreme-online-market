package io.soboro.supreme.core.model.product.vo

import io.soboro.supreme.core.model.product.enums.Option

data class ProductDetail(
    val id: Long,
    val items: List<OptionProduct>,
    val productName: String,
    val brandName: String,
    val description: String,
    val detailImages: List<DetailImage>,
) {
    data class OptionProduct(
        val option: Option,
        val stock: Int,
    )

    data class DetailImage(
        val url: String,
        val order: Int,
        val description: String,
    )
}
