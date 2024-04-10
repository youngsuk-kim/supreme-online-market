package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.product.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface JpaProductRepository : JpaRepository<Product, Long>
