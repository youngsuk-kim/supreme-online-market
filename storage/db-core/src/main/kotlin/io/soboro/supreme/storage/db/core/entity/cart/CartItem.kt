package io.soboro.supreme.storage.db.core.entity.cart

import io.soboro.supreme.storage.db.core.entity.BaseEntity
import io.soboro.supreme.storage.db.core.entity.product.entity.Product
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne

@Entity
class CartItem(
    @ManyToOne(fetch = FetchType.LAZY) var cart: Cart,
    @ManyToOne(fetch = FetchType.LAZY) var product: Product,
): BaseEntity()
