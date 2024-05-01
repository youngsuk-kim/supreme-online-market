package io.soboro.supreme.order.clients

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClient.Builder

@Configuration
class WebClientConfig {

    @Bean
    fun webClientBuilder(): Builder {
        return WebClient.builder()
            .exchangeStrategies(ExchangeStrategies.builder().codecs(this::configureClientDefaultCodecs).build())
    }

    private fun configureClientDefaultCodecs(clientCodecConfigurer: ClientCodecConfigurer) {
        clientCodecConfigurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024) // 16MB
    }

    @Bean
    fun webClient(webClientBuilder: Builder): WebClient {
        return webClientBuilder.baseUrl("http://localhost:8080").build()
    }
}
