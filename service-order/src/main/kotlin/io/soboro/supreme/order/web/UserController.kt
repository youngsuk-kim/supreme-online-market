package io.soboro.supreme.order.web

import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/users")
    suspend fun listUsers(): Flow<User> = userService.getAllUsers()

    @PostMapping("/users")
    suspend fun addUser(@RequestBody user: User): User = userService.addUser(user)
}
