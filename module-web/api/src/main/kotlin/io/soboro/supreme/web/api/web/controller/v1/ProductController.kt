package io.soboro.supreme.web.api.web.controller.v1

import io.soboro.supreme.core.application.ProductService
import io.soboro.supreme.core.model.product.enums.ProductType
import io.soboro.supreme.core.model.product.vo.ProductDetail
import io.soboro.supreme.web.api.support.response.ApiResponse
import io.soboro.supreme.web.api.web.controller.v1.response.ProductResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService,
) {

    @GetMapping("/api/v1/products/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<ApiResponse<ProductDetail>> {
        return ResponseEntity.ok(ApiResponse.success(productService.detail(id)))
    }

    @GetMapping("/api/v1/products")
    fun list(): ResponseEntity<ApiResponse<List<ProductResponse>>> {
        val responses = productService.list(ProductType.NORMAL)
            .map { product -> ProductResponse.from(product) }

        return ResponseEntity.ok(ApiResponse.success(responses))
    }
}
