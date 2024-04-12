package io.soboro.supreme.web.api.web.controller.v1.request

import io.soboro.supreme.core.model.common.Address
import io.soboro.supreme.core.model.product.enums.Option
import io.soboro.supreme.core.model.shipment.Shipping
import java.math.BigDecimal

class OrderPlaceRequest (
    val senderName: String,
    val senderPhoneNumber: String,
    val receiverName: String,
    val receiverPhoneNumber: String,
    val destination: Address,
    val cart: Cart
) {
    data class Cart(
        var userId: Long,
        var cartItems: List<CartOptionItem>,
    ) {

        data class CartOptionItem(
            val name: String,
            val option: Option,
            val count: Int,
            val price: BigDecimal
        )
    }

    fun toShippingInfo(): Shipping {
        return Shipping(senderName, senderPhoneNumber, receiverName, receiverPhoneNumber, destination)
    }

    fun toCart(): io.soboro.supreme.core.model.order.Cart {
        return io.soboro.supreme.core.model.order.Cart(
            userId = cart.userId,
            cartItems = cart.cartItems.map {
                io.soboro.supreme.core.model.order.Cart.CartOptionItem(
                    it.name, it.option, it.count, it.price
                )
            }
        )
    }
}