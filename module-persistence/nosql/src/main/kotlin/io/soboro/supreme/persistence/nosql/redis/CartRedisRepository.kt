package io.soboro.supreme.persistence.nosql.redis

import com.fasterxml.jackson.databind.ObjectMapper
import io.soboro.supreme.core.model.cart.Cart
import io.soboro.supreme.core.model.cart.CartItem
import io.soboro.supreme.core.model.product.repository.CartRepository
import io.soboro.supreme.core.support.JsonUtility
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class CartRedisRepository(
    private val redisTemplate: RedisTemplate<String, String>,
    private val jsonUtility: JsonUtility,
    private val objectMapper: ObjectMapper,
) : CartRepository {
    private val cartPrefix = "cart:userId:"

    override fun add(userId: Long, cartItem: CartItem) {
        val cartKey = "$cartPrefix$userId"
        val currentCartJson = redisTemplate.opsForValue().get(cartKey)
        val currentCart = currentCartJson?.let { jsonUtility.fromJson(it, Cart::class.java) }
        val updatedCart = currentCart?.apply {
            cartItems = cartItems + cartItem
        } ?: Cart(userId, listOf(cartItem))

        jsonUtility.toJson(updatedCart)?.let {
            redisTemplate.opsForValue().set(cartKey, it)
        }
    }

    override fun remove(userId: Long, cartItem: CartItem) {
        val cartKey = "$cartPrefix$userId"
        val cartJson = redisTemplate.opsForValue().get(cartKey)
        val cart = cartJson?.let { jsonUtility.fromJson(it, Cart::class.java) }

        cart?.let {
            it.cartItems = it.cartItems.filterNot { item ->
                item.productName == cartItem.productName && item.option == cartItem.option
            }
            jsonUtility.toJson(it)?.let { updatedCartJson ->
                redisTemplate.opsForValue().set(cartKey, updatedCartJson)
            }
        }
    }

    override fun clear(userId: Long) {
        val cartKey = "$cartPrefix$userId"
        redisTemplate.delete(cartKey)
    }

    override fun get(userId: Long): Cart {
        val cartKey = "$cartPrefix$userId"
        return redisTemplate.opsForValue().get(cartKey)?.let { jsonUtility.fromJson(it, Cart::class.java) }
            ?: throw IllegalArgumentException()
    }
}
