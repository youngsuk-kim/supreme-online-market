package io.soboro.supreme.web.api.web.controller.v1

import io.soboro.supreme.core.application.OrderService
import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.web.api.support.annotation.Login
import io.soboro.supreme.web.api.support.response.ApiResponse
import io.soboro.supreme.web.api.web.controller.v1.request.OrderPlaceRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderService: OrderService,
) {
    @PostMapping("/api/v1/orders")
    fun order(@Login user: User, @RequestBody request: OrderPlaceRequest): ResponseEntity<ApiResponse<Any>> {
        orderService.place(user.id!!, request.toProductUnits(), request.toShipping())
        return ResponseEntity.ok(ApiResponse.success())
    }
}
