package io.soboro.supreme.order.domain.shipment.entity

import io.soboro.supreme.order.domain.common.BaseEntity
import io.soboro.supreme.order.domain.shipment.vo.Shipping
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("shipment")
class Shipment(
    @Id var id: Long? = null,
    @Column var orderId: Long,
    @Column var senderName: String,
    @Column var senderPhoneNumber: String,
    @Column var receiverName: String,
    @Column var receiverPhoneNumber: String,
    // 시
    @Column var city: String,
    // 도
    @Column var province: String,
    // 상세 주소
    @Column var detail: String,
) : BaseEntity() {

    companion object {
        fun create(orderId: Long, shipping: Shipping): Shipment {
            return Shipment(
                orderId = orderId,
                senderName = shipping.senderName,
                senderPhoneNumber = shipping.senderPhoneNumber,
                receiverName = shipping.receiverName,
                receiverPhoneNumber = shipping.receiverPhoneNumber,
                city = shipping.destination.city,
                province = shipping.destination.province,
                detail = shipping.destination.detail,
            )
        }
    }
}
