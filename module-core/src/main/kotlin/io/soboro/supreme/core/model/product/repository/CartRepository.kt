package io.soboro.supreme.core.model.product.repository

interface CartRepository {
    fun add(userId: String, sku: String)
    fun remove(userId: String, sku: String)
    fun clear(userId: String)
    fun get(userId: String): List<String>
}
