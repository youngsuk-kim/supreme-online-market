package io.soboro.supreme.storage.db.core.entity.product.entity

import io.soboro.supreme.storage.db.core.entity.BaseEntity
import io.soboro.supreme.storage.db.core.entity.product.vo.Host
import io.soboro.supreme.storage.db.core.entity.product.vo.ImageType
import jakarta.persistence.Entity

@Entity
class Image(
    val host: Host,
    val port: Int,
    val path: String,
    val type: ImageType,
): BaseEntity()
