package io.soboro.supreme.order.application

interface ProductApi {
    suspend fun isStockEnoughForSale(
        productId: Long,
        productItemId: Long,
        quantity: Long,
    ): Boolean
}
