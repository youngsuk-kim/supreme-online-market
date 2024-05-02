package io.soboro.supreme.order.infrastructure.clients

import io.soboro.supreme.order.application.AuthApi
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class AuthClient(
    private val webClient: WebClient,
) : AuthApi {
    override suspend fun isLogin(token: String): Boolean {
        return webClient.post()
            .uri("/api/v1/auth/login/session")
            .accept(MediaType.APPLICATION_JSON)
            .header(HttpHeaders.AUTHORIZATION, "Bearer $token")
            .bodyValue(token)
            .exchangeToMono { response -> Mono.just(response.statusCode().is2xxSuccessful) }
            .awaitSingle()
    }
}
