package io.soboro.supreme.order.clients

import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [WebClientConfig::class, AuthClient::class])
class AuthClientTest {

    @Autowired
    lateinit var authClient: AuthClient

    @Test
    fun `check user session is valid`() {
        runBlocking {
            val login =
                authClient.isLogin("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJjb2xhYmVhcjc1NCIsImV4cCI6MTcxNDUzMzU3Miwic3ViIjoiZHVkdGpycmxhMTIhIiwidXNlcm5hbWUiOiJ0aGF5ZXIyMzkxQG5hdmVyLmNvbSJ9.rqwV-Xyj1M0oRfPnZOtwC9RDORs_dmTB5tnfRGciitE")
            assertThat(login).isTrue()
        }
    }
}
