package io.soboro.supreme.order.domain.order.vo

data class OrderUnit(
    var sku: Long,
    var option: Option,
    var optionName: String,
    var stock: Long,
    var productId: Long,
)
