package io.soboro.supreme.order.infrastructure.clients

import io.soboro.supreme.order.application.AuthApi
import io.soboro.supreme.order.presentation.rest.response.ApiResponse
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class AuthClient(
    private val webClient: WebClient,
) : AuthApi {
    override suspend fun getUserId(token: String): Int {
        val response = webClient.get()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/api/v1/auth/users")
                    .queryParam("token", token)
                    .build()
            }
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(ApiResponse::class.java)
            .awaitSingle()

        println(response)

        return response.data as Int
    }
}
