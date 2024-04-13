package io.soboro.supreme.web.api.web.controller.v1.request

import io.soboro.supreme.core.model.common.Address
import io.soboro.supreme.core.model.order.vo.Cart
import io.soboro.supreme.core.model.product.enums.OptionTitle
import io.soboro.supreme.core.model.shipment.vo.Shipping
import java.math.BigDecimal

data class OrderPlaceRequest(
    val senderName: String,
    val senderPhoneNumber: String,
    val receiverName: String,
    val receiverPhoneNumber: String,
    val destination: Address,
    val cart: Cart,
) {
    data class Cart(
        var userId: Long,
        var cartOptionGroups: List<CartOptionGroup>,
    ) {

        data class CartOptionGroup(
            val options: List<CartOptionItem>,
            val productName: String,
            val price: BigDecimal,
            val count: Int,
        )

        data class CartOptionItem(
            val orderItemId: Long,
            val optionName: String,
            val optionTitle: OptionTitle,
        )
    }

    fun toShippingInfo(): Shipping {
        return Shipping(senderName, senderPhoneNumber, receiverName, receiverPhoneNumber, destination)
    }

    fun toCart(): io.soboro.supreme.core.model.order.vo.Cart {
        val cartOptionGroups = cart.cartOptionGroups.map { cartOptionGroup ->
            val options = cartOptionGroup.options.map { cartOptionItem ->
                io.soboro.supreme.core.model.order.vo.Cart.CartOptionItem(
                    orderItemId = cartOptionItem.orderItemId,
                    optionName = cartOptionItem.optionName,
                    optionTitle = cartOptionItem.optionTitle,
                )
            }
            io.soboro.supreme.core.model.order.vo.Cart.CartOptionGroup(
                options = options,
                productName = cartOptionGroup.productName,
                count = cartOptionGroup.count,
                price = cartOptionGroup.price,
            )
        }
        return Cart(
            userId = cart.userId,
            cartOptionGroups = cartOptionGroups,
        )
    }
}
