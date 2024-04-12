package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.cart.CartRepository
import org.springframework.stereotype.Repository

@Repository
class CartRepositoryAdapter(
    private val cartJpaRepository: CartJpaRepository,
) : CartRepository