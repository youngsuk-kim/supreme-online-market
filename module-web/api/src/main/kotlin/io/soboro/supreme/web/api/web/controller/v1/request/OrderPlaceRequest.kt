package io.soboro.supreme.web.api.web.controller.v1.request

import io.soboro.supreme.core.model.common.Address
import io.soboro.supreme.core.model.product.enums.Option
import io.soboro.supreme.core.model.shipment.Shipping
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
            val option: Option,
        )
    }

    fun toShippingInfo(): Shipping {
        return Shipping(senderName, senderPhoneNumber, receiverName, receiverPhoneNumber, destination)
    }

    fun toCart(): io.soboro.supreme.core.model.order.Cart {
        val cartOptionGroups = cart.cartOptionGroups.map { cartOptionGroup ->
            val options = cartOptionGroup.options.map { cartOptionItem ->
                io.soboro.supreme.core.model.order.Cart.CartOptionItem(
                    orderItemId = cartOptionItem.orderItemId,
                    optionName = cartOptionItem.optionName,
                    option = cartOptionItem.option
                )
            }
            io.soboro.supreme.core.model.order.Cart.CartOptionGroup(
                options = options,
                productName = cartOptionGroup.productName,
                count = cartOptionGroup.count,
                price = cartOptionGroup.price
            )
        }
        return io.soboro.supreme.core.model.order.Cart(
            userId = cart.userId,
            cartOptionGroups = cartOptionGroups
        )
    }
}