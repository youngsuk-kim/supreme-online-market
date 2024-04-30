package io.soboro.supreme.core.model.cart

data class Cart(
    var userId: Long,
    var productUnits: List<ProductUnit>,
)
