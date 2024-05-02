package io.soboro.supreme.order.clients

import io.soboro.supreme.order.infrastructure.clients.AuthClient
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
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = [AuthClient::class, WebClientConfig::class])
class AuthClientTest {

    @Autowired
    private lateinit var authClient: AuthClient
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
    fun `check user session is valid`() {
        runBlocking {
            // given
            val token = "example-token"

            val responseBody = """
                    {
                      "data": {
                        "token": "$token"
                      },
                    }
            """.trimIndent()

            // when
            mockServer.`when`(
                HttpRequest.request()
                    .withMethod("POST")
                    .withPath("/api/v1/auth/login/session"),
            ).respond(
                HttpResponse.response()
                    .withBody(responseBody)
                    .withStatusCode(200),
            )

            val sut = authClient.isLogin(token)

            // then
            assertThat(sut).isTrue()
        }
    }
}
