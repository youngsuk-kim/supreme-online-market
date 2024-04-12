package io.soboro.supreme.web.api.web.controller.v1

import io.soboro.supreme.core.service.LoginService
import io.soboro.supreme.core.service.RegisterService
import io.soboro.supreme.web.api.support.response.ApiResponse
import io.soboro.supreme.web.api.support.security.JwtProcessor
import io.soboro.supreme.web.api.web.controller.v1.request.UserLoginRequest
import io.soboro.supreme.web.api.web.controller.v1.request.UserRegisterRequest
import io.soboro.supreme.web.api.web.controller.v1.response.UserLoginResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val registerService: RegisterService,
    private val loginService: LoginService,
    private val jwtProcessor: JwtProcessor,
) {

    @PostMapping("/api/v1/register")
    fun register(@RequestBody request: UserRegisterRequest): ResponseEntity<ApiResponse<Any>> {
        registerService.register(request.toUser(), request.checkPassword)

        return ResponseEntity.ok(ApiResponse.success())
    }

    @PostMapping("/api/v1/login")
    fun login(@RequestBody request: UserLoginRequest): ResponseEntity<ApiResponse<UserLoginResponse>> {
        loginService.validateUser(request.email, request.password)

        val token = jwtProcessor.generateToken(request.email, request.password)

        return ResponseEntity.ok(ApiResponse.success(UserLoginResponse(token)))
    }
}
