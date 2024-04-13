package io.soboro.supreme.core.model.order

import io.soboro.supreme.core.model.product.enums.OptionTitle
import java.math.BigDecimal

data class Cart(
    var userId: Long,
    var cartOptionGroups: List<CartOptionGroup>,
) {

    data class CartOptionGroup(
        val options: List<CartOptionItem>,
        val productName: String,
        val count: Int,
        val price: BigDecimal,
    )

    data class CartOptionItem(
        val orderItemId: Long,
        val optionName: String,
        val optionTitle: OptionTitle,
    )
}

