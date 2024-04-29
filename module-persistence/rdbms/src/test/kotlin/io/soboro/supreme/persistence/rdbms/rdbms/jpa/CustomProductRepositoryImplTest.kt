package io.soboro.supreme.persistence.rdbms.rdbms.jpa

import io.lettuce.core.RedisClient
import io.soboro.supreme.persistence.rdbms.nosql.LettuceConfig
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [io.soboro.supreme.persistence.rdbms.nosql.LettuceConfig::class])
class CustomProductRepositoryImplTest {

    @Autowired
    private lateinit var redisClient: RedisClient

    @Test
    fun `redis connection test`() {
        redisClient.connect().sync()
            .hset("userId", "productId", "1")
    }

//    @Test
//    fun `products pagination`() {
//        repository.paginationNoOffsetBuilder(1L, "신발", 1L)
//    }
}
