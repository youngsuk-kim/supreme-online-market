package io.soboro.supreme.order.domain.shipment.vo

import io.soboro.supreme.order.domain.common.Address

data class Shipping(
    val senderName: String,
    val senderPhoneNumber: String,
    val receiverName: String,
    val receiverPhoneNumber: String,
    val destination: Address,
)
