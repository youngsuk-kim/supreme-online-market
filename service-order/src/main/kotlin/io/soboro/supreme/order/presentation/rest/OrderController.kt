package io.soboro.supreme.order.presentation.rest

import io.soboro.supreme.order.application.OrderService
import io.soboro.supreme.order.presentation.rest.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderService: OrderService,
) {
    @PostMapping("/api/v1/orders/{userId}")
    suspend fun order(
        @RequestHeader("Authorization") token: String,
        @PathVariable userId: Long,
        @RequestBody request: OrderPlaceRequest,
    ): ResponseEntity<ApiResponse<Any>> {
        orderService.place(
            token = token,
            userId = userId,
            orderUnits = request.toProductUnits(),
            shipping = request.toShipping(),
        )
        return ResponseEntity.ok(ApiResponse.success())
    }
}
