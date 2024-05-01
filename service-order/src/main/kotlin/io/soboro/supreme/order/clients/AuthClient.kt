package io.soboro.supreme.order.clients

import io.soboro.supreme.order.core.application.AuthService
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class AuthClient(
    private val webClient: WebClient,
) : AuthService {
    override suspend fun isLogin(token: String): Boolean {
        return webClient.post()
            .uri("/api/v1/auth/login/session")
            .header("Authorization", "Bearer $token")
            .retrieve()
            .bodyToMono(Boolean::class.java)
            .awaitSingle()
    }
}
