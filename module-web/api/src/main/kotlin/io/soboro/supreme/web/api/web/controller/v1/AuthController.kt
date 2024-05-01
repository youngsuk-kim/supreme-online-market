package io.soboro.supreme.web.api.web.controller.v1

import io.soboro.supreme.core.application.AuthService
import io.soboro.supreme.core.application.RegisterService
import io.soboro.supreme.support.web.response.ApiResponse
import io.soboro.supreme.web.api.support.security.JwtProcessor
import io.soboro.supreme.web.api.web.controller.v1.request.UserLoginRequest
import io.soboro.supreme.web.api.web.controller.v1.request.UserRegisterRequest
import io.soboro.supreme.web.api.web.controller.v1.response.UserLoginResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    private val registerService: RegisterService,
    private val authService: AuthService,
    private val jwtProcessor: JwtProcessor,
) {

    @PostMapping("/api/v1/auth/register")
    fun register(@RequestBody request: UserRegisterRequest): ResponseEntity<ApiResponse<Any>> {
        registerService.register(request.toUser(), request.checkPassword)

        return ResponseEntity.ok(ApiResponse.success())
    }

    @PostMapping("/api/v1/auth/login")
    fun login(@RequestBody request: UserLoginRequest): ResponseEntity<ApiResponse<UserLoginResponse>> {
        authService.validate(request.email, request.password)

        val token = jwtProcessor.generateToken(request.email, request.password)
        authService.login(request.email, request.password, token)

        return ResponseEntity.ok(ApiResponse.success(UserLoginResponse(token)))
    }

    @PostMapping("/api/v1/auth/login/session")
    fun hasSession(@RequestHeader("Authorization") token: String): ResponseEntity<ApiResponse<Unit>> {
        if (!jwtProcessor.isOk(token)) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        return ResponseEntity.ok().build()
    }
}
