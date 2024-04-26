package io.soboro.supreme.web.api.web.controller.v1

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PaymentController {

    @PostMapping("/api/v1/payments/webhook")
    fun webhook() {
        println("webhook")
    }

}