package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.repository.ProductCustomRepository
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface ProductJpaCustomRepository : JpaRepository<Product, Long>, ProductCustomRepository {
    @EntityGraph(attributePaths = ["images"])
    override fun findAll(): List<Product>
}
