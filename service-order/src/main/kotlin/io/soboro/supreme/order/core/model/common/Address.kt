package io.soboro.supreme.order.core.model.common

data class Address(
    // 시
    var city: String,
    // 도
    var province: String,
    // 상세 주소
    var detail: String,
) {
    fun updateTo(address: Address): Address {
        return Address(address.city, address.province, address.detail)
    }

    /**
     * 임시 개발
     */
    fun isIsland(): Boolean {
        return this.city.contains("제주")
    }
}
