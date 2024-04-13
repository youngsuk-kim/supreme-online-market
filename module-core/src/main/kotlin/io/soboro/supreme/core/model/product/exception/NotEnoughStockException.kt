package io.soboro.supreme.core.model.product.exception

class NotEnoughStockException(productName: String) : RuntimeException("Not enough stock, product name: $productName")
