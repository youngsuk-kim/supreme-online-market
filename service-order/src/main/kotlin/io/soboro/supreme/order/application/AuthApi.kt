package io.soboro.supreme.order.application

interface AuthApi {
    suspend fun getUserId(token: String): Int
}
