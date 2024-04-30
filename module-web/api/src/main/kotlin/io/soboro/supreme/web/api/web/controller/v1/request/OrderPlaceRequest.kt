package io.soboro.supreme.web.api.web.controller.v1.request

import io.soboro.supreme.core.model.common.Address
import io.soboro.supreme.core.model.product.enums.Option
import io.soboro.supreme.core.model.product.vo.ProductUnit
import io.soboro.supreme.core.model.shipment.vo.Shipping

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

    fun toProductUnits(): List<ProductUnit> {
        return orderItems.map { item ->
            ProductUnit(sku = item.sku, option = item.option, optionName = item.optionName, stock = item.quantity)
        }
    }
}
