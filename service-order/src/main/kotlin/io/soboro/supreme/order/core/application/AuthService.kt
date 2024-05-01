package io.soboro.supreme.order.core.application

interface AuthService {
    suspend fun isLogin(token: String): Boolean
}
