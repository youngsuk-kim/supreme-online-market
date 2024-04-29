package io.soboro.supreme.persistence.nosql.redis

import io.lettuce.core.RedisClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LettuceConfig {

    @Bean
    fun redisClient(): RedisClient {
        return RedisClient.create("redis://@localhost:6379/0")
    }
}
