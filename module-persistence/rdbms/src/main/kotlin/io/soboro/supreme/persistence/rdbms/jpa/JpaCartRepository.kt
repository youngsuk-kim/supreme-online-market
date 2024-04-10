package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.cart.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface JpaCartRepository : JpaRepository<Cart, Long>
