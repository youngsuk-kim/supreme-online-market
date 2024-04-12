package io.soboro.supreme.web.api.web.controller.v1

import io.soboro.supreme.core.application.OrderService
import io.soboro.supreme.web.api.web.controller.v1.request.OrderPlaceRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderService: OrderService
) {

    @PostMapping("/api/v1/order")
    fun order(@RequestBody request: OrderPlaceRequest) {
        orderService.place(request.toCart(), request.toShippingInfo())
    }

    /**
     * client ---products, shipping info--> server
     *
     * 1. server receive(skuList, shipping info)
     * 2. find products by skuList
     * 3. check products stock
     * 4. save order (status ORDERED)
     * 5. save shipment (status PENDING)
     *
     * 1. server receive shipping info
     * 2. server receive Cart
     *
     * data class Cart(
     *     var userId: Long,
     *     var cartItems: MutableList<CartOptionItem>,
     * ) {
     *
     *     data class CartOptionItem(
     *         val name: String,
     *         val option: Option,
     *         val count: Int
     *     )
     * }
     *
     */
}