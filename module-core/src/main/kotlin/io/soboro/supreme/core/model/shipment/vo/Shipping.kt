package io.soboro.supreme.core.model.shipment.vo

import io.soboro.supreme.core.model.common.Address
import jakarta.persistence.Embeddable

@Embeddable
data class Shipping (
    val senderName: String,
    val senderPhoneNumber: String,
    val receiverName: String,
    val receiverPhoneNumber: String,
    val destination: Address,
)