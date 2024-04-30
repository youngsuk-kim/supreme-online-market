package io.soboro.supreme.order.core.model.order.vo

data class OrderUnit(
    var sku: String,
    var option: Option,
    var optionName: String,
    var stock: Int,
)
