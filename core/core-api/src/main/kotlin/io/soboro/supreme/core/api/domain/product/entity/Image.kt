package io.soboro.supreme.core.api.domain.product.entity

import io.soboro.supreme.core.api.domain.product.vo.Host
import io.soboro.supreme.core.api.domain.product.vo.ImageType
import java.time.LocalDateTime

class Image(
    val host: Host,
    val port: Int,
    val path: String,
    val type: ImageType,
    val createdAt: LocalDateTime,
    val deletedAt: LocalDateTime? = null,
)
