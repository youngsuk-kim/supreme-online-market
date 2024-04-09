package me.bread.supreme.integration.domain.product.entity

import me.bread.supreme.integration.domain.money.Money
import me.bread.supreme.integration.domain.product.enums.ProductType
import java.time.LocalDateTime

class Product(
	var productType: ProductType,
	var name: String,
	var brandName: String,
	var description: String,
	var price: Money,
	var timeLimit: TimeLimit,
	private var productOption: ProductOption,
	var images: List<Image>,
) {
	fun canBuy(now: LocalDateTime = LocalDateTime.now()): Boolean {
		// 구매 마감 시간 지났는지
		if (this.timeLimit.timeOver(now)) return false

		// 상품 옵션이 부족 한지
		if (this.productOption.enough()) return false

		return true
	}

	fun price(): Money {
		return this.price
	}
}
