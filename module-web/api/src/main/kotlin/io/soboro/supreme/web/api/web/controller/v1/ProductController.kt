package io.soboro.supreme.web.api.web.controller.v1

import io.soboro.supreme.core.application.ProductService
import io.soboro.supreme.core.model.product.vo.ProductDetail
import io.soboro.supreme.web.api.support.response.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService
) {

    @GetMapping("/api/v1/products/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<ApiResponse<ProductDetail>> {
        return ResponseEntity.ok(ApiResponse.success(productService.detail(id)))
    }
}