package io.soboro.supreme.order.clients

import io.soboro.supreme.order.infrastructure.clients.ProductClient
import io.soboro.supreme.order.infrastructure.clients.WebClientConfig
import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockserver.integration.ClientAndServer
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse
import org.mockserver.model.Parameter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = [ProductClient::class, WebClientConfig::class])
class ProductClientTest {

    @Autowired
    private lateinit var productClient: ProductClient
    private lateinit var mockServer: ClientAndServer

    @BeforeAll
    fun startServer() {
        this.mockServer = ClientAndServer.startClientAndServer(8089)
    }

    @AfterAll
    fun stopServer() {
        this.mockServer.stop()
    }

    @Test
    fun `check enough stock`() {
        runBlocking {
            // given
            val productId = 1L
            val productItemId = 1L
            val quantity = 1L

            val responseBody = """
                    {
                      "data": true
                    }
            """.trimIndent()

            // when
            mockServer.`when`(
                HttpRequest.request()
                    .withMethod("POST")
                    .withPath("/api/v1/products/$productId/enough-stock")
                    .withQueryStringParameters(
                        Parameter("quantity", quantity.toString()),
                        Parameter("productItemId", productItemId.toString()),
                    ),
            ).respond(
                HttpResponse.response()
                    .withBody(responseBody)
                    .withHeader("Content-Type", "application/json")
                    .withStatusCode(200),
            )

            val sut = productClient.isStockEnoughForSale(productId, productItemId, quantity)

            // then
            assertThat(sut).isTrue()
        }
    }
}
