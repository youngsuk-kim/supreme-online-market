package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.cart.Cart
import io.soboro.supreme.core.repository.CartRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface CartJpaRepository : JpaRepository<Cart, Long>

@Repository
class CartRepositoryAdapter(
    private val cartJpaRepository: CartJpaRepository,
) : CartRepository
