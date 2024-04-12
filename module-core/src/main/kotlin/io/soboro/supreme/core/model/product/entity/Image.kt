package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import io.soboro.supreme.core.model.product.enums.Host
import io.soboro.supreme.core.model.product.enums.ImageType
import jakarta.persistence.Entity

@Entity
class Image(
    val host: Host,
    val port: Int,
    val path: String,
    val type: ImageType,
) : BaseEntity()
