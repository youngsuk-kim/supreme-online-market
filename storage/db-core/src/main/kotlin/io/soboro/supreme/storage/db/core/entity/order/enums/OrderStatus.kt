package io.soboro.supreme.storage.db.core.entity.order.enums

enum class OrderStatus {
    // 주문 대기
    PENDING,

    // 결제 완료
    PAYED,

    // 배송 완료
    DELIVERED,
}
