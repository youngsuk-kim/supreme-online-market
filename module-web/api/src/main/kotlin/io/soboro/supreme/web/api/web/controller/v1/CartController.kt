package io.soboro.supreme.web.api.web.controller.v1

import io.soboro.supreme.core.application.CartService
import io.soboro.supreme.core.model.cart.Cart
import io.soboro.supreme.core.model.cart.CartItem
import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.web.api.support.annotation.Login
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CartController(
    private val cartService: CartService,
) {

    @PostMapping("/api/v1/carts")
    fun add(@Login user: User, @RequestBody cartItem: CartItem) {
        cartService.add(user.id!!, cartItem)
    }

    @GetMapping("/api/v1/carts")
    fun add(@Login user: User): Cart {
        return cartService.get(user.id!!)
    }
}
