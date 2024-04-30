package io.soboro.supreme.order.web

import io.soboro.supreme.order.core.model.common.Address
import io.soboro.supreme.order.core.model.order.vo.Option
import io.soboro.supreme.order.core.model.order.vo.OrderUnit
import io.soboro.supreme.order.core.model.shipment.vo.Shipping

data class OrderPlaceRequest(
    val orderItems: List<OrderItem>,
    val senderName: String,
    val senderPhoneNumber: String,
    val receiverName: String,
    val receiverPhoneNumber: String,
    val destination: Address,
) {
    data class OrderItem(
        val sku: String,
        val quantity: Int,
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
            OrderUnit(sku = item.sku, option = item.option, optionName = item.optionName, stock = item.quantity)
        }
    }
}
