package io.soboro.supreme.web.api.web.controller.v1

import io.soboro.supreme.core.application.AuthService
import io.soboro.supreme.core.application.RegisterService
import io.soboro.supreme.web.api.support.response.ApiResponse
import io.soboro.supreme.web.api.support.security.JwtProcessor
import io.soboro.supreme.web.api.web.controller.v1.request.UserLoginRequest
import io.soboro.supreme.web.api.web.controller.v1.request.UserRegisterRequest
import io.soboro.supreme.web.api.web.controller.v1.response.UserLoginResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
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

    @GetMapping("/api/v1/auth/users")
    fun getByToken(@RequestParam token: String): ResponseEntity<ApiResponse<Long?>> {
        return ResponseEntity.ok(ApiResponse.success(authService.getUserFromToken(token).id))
    }
}
