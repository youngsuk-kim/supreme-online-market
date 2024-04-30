package io.soboro.supreme.order.web

import io.soboro.supreme.order.core.application.OrderService
import io.soboro.supreme.support.web.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderService: OrderService,
) {
    @PostMapping("/api/v1/orders/{userId}")
    fun order(@PathVariable userId: Long, @RequestBody request: OrderPlaceRequest): ResponseEntity<ApiResponse<Any>> {
        orderService.place(userId, request.toProductUnits(), request.toShipping())
        return ResponseEntity.ok(ApiResponse.success())
    }
}
