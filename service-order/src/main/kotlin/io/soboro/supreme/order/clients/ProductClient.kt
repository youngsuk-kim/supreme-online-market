package io.soboro.supreme.order.clients

import io.soboro.supreme.order.core.application.ProductApi
import org.springframework.stereotype.Component

@Component
class ProductClient: ProductApi {
    override suspend fun isStockEnoughForSale(): Boolean {
        return true
    }
}