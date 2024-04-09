package me.bread.supreme.integration.domain.product.entity

import me.bread.supreme.integration.domain.product.vo.Host
import me.bread.supreme.integration.domain.product.vo.ImageType
import java.time.LocalDateTime

class Image(
	val host: Host,
	val port: Int,
	val path: String,
	val type: ImageType,
	val createdAt: LocalDateTime,
	val deletedAt: LocalDateTime? = null,
)
