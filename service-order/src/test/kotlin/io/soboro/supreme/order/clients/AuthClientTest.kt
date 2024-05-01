package io.soboro.supreme.order.clients

import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@SpringBootTest(classes = [WebClientConfig::class, AuthClient::class])
class AuthClientTest {

    @Autowired
    lateinit var authClient: AuthClient

    @Test
    fun `check user session is valid`() {
        runBlocking {
            // given
            val token = "example-token"

            // when
            val sut = authClient.isLogin(token)

            // then
            assertThat(sut).isTrue()
        }
    }
}
