package io.soboro.supreme.core.model.cart

import io.soboro.supreme.core.model.BaseEntity
import io.soboro.supreme.core.model.product.entity.Product
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne

@Entity
class CartItem(
    @ManyToOne(fetch = FetchType.LAZY) var cart: Cart,
    @ManyToOne(fetch = FetchType.LAZY) var product: Product,
) : BaseEntity()
