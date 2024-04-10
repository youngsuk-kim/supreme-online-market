package io.soboro.supreme.core.api.web.controller.v1

import io.soboro.supreme.core.api.web.controller.v1.request.UserRegisterRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @PostMapping("/api/v1/register")
    fun register(@RequestBody request: UserRegisterRequest) {
        
    }
}