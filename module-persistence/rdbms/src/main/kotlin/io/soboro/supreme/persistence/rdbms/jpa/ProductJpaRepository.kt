package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.repository.CustomProductRepository
import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaRepository : JpaRepository<Product, Long>, CustomProductRepository
