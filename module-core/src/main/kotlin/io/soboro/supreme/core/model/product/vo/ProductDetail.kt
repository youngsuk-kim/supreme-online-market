package io.soboro.supreme.core.model.product.vo

data class ProductDetail(
    val id: Long,
    val optionGroups: List<OptionGroup>,
    val productName: String,
    val brandName: String,
    val description: String,
    val detailImages: List<DetailImage>,
) {
    data class OptionGroup(
        val options: List<Option>,
        val stock: Int,
    )

    data class Option(
        val optionTitle: String,
        val optionName: String,
    )

    data class DetailImage(
        val url: String,
        val order: Int,
        val description: String,
    )
}
