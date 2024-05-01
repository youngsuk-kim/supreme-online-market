package io.soboro.supreme.order.core.application

interface AuthApi {
    suspend fun isLogin(token: String): Boolean
}
