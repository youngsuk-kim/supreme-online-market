package io.soboro.supreme.order.core.application

interface ProductApi {
    suspend fun isStockEnoughForSale(
        productId: Long,
        productItemId: Long,
        quantity: Long,
    ): Boolean
}
