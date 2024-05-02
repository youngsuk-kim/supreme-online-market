package io.soboro.supreme.order.application

interface AuthApi {
    suspend fun isLogin(token: String): Boolean
}
