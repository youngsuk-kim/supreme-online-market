package io.soboro.supreme.order.core.application

interface ProductApi {
    suspend fun isStockEnoughForSale(): Boolean
}