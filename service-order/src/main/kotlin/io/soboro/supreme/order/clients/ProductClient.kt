package io.soboro.supreme.order.clients

import io.soboro.supreme.order.core.application.ProductApi
import io.soboro.supreme.support.web.response.ApiResponse
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class ProductClient(
    private val webClient: WebClient,
) : ProductApi {

    override suspend fun isStockEnoughForSale(productId: Long, productItemId: Long, quantity: Long): Boolean {
        val response = webClient.post()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/api/v1/products/$productId/enough-stock")
                    .queryParam("productItemId", productItemId)
                    .queryParam("quantity", quantity)
                    .build()
            }
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(ApiResponse::class.java)
            .awaitSingle()

        return response.data as Boolean
    }
}
