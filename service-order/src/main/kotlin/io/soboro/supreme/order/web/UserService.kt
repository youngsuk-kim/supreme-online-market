package io.soboro.supreme.order.web

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(private val userRepository: UserRepository) {

    @Transactional
    suspend fun getAllUsers(): Flow<User> = userRepository.findAll().asFlow()

    @Transactional
    suspend fun addUser(user: User): User = userRepository.save(user).awaitSingle()
}
