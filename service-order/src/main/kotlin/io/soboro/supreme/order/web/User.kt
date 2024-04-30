package io.soboro.supreme.order.web

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "users")
data class User(
    @Id val id: Long? = null,
    val name: String,
    val age: Int,
)
