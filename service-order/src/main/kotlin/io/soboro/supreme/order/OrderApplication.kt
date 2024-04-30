package io.soboro.supreme.order

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class OrderApplication

fun main(args: Array<String>) {
    System.setProperty("spring.devtools.restart.enabled", "false")
    runApplication<OrderApplication>(*args)
}

@RestController
class ServerInfoController {
    @Value("\${server.port}")
    private val serverPort = 0

    @GetMapping("/server-info")
    fun serverInfo(): String {
        return "This request was handled by the server running on port: $serverPort"
    }
}
