package io.soboro.supreme.order.presentation.rest

import io.soboro.supreme.order.domain.common.Address
import io.soboro.supreme.order.domain.order.vo.Option
import io.soboro.supreme.order.domain.order.vo.OrderUnit
import io.soboro.supreme.order.domain.shipment.vo.Shipping

data class OrderPlaceRequest(
    val orderItems: List<OrderItem>,
    val senderName: String,
    val senderPhoneNumber: String,
    val receiverName: String,
    val receiverPhoneNumber: String,
    val destination: Address,
) {
    data class OrderItem(
        val productId: Long,
        val sku: Long,
        val quantity: Long,
        val option: Option,
        val optionName: String,
    )

    fun toShipping(): Shipping {
        return Shipping(
            senderName = senderName,
            senderPhoneNumber = senderPhoneNumber,
            receiverName = receiverName,
            receiverPhoneNumber = receiverPhoneNumber,
            destination = destination,
        )
    }

    fun toProductUnits(): List<OrderUnit> {
        return orderItems.map { item ->
            OrderUnit(
                productId = item.productId,
                sku = item.sku,
                option = item.option,
                optionName = item.optionName,
                stock = item.quantity,
            )
        }
    }
}
