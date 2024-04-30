package io.soboro.supreme.persistence.nosql.redis

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate

@SpringBootTest(classes = [RedisConfig::class])
class RedisConfigTest {

    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, Any>

    @Test
    fun practice() {
        redisTemplate.opsForHash<String, String>().put("cart:1", "1", "nike")
    }
}
