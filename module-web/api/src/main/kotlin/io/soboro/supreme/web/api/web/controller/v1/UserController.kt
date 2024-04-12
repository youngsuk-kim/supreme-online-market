package io.soboro.supreme.web.api.web.controller.v1

import io.soboro.supreme.core.service.UserRegisterService
import io.soboro.supreme.web.api.support.response.ApiResponse
import io.soboro.supreme.web.api.web.controller.v1.request.UserRegisterRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userRegisterService: UserRegisterService,
) {

    @PostMapping("/api/v1/register")
    fun register(@RequestBody request: UserRegisterRequest): ResponseEntity<ApiResponse<Void>> {
        userRegisterService.register(request.toUserRegister())

        return ResponseEntity.ok().build()
    }
}
