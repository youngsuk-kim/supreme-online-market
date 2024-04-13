package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.common.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Entity
@Table(name = "product_time_limit")
class ProductTimeLimit(
    var startTime: LocalDateTime,
    var endTime: LocalDateTime,
) : BaseEntity() {
    companion object {
        fun create(
            startTime: LocalDateTime,
            endTime: LocalDateTime,
        ): ProductTimeLimit {
            return ProductTimeLimit(
                startTime = startTime,
                endTime = endTime,
            )
        }
    }

    fun timeOver(now: LocalDateTime = LocalDateTime.now()): Boolean {
        return now.isAfter(endTime)
    }

    fun plusStartTime(
        time: Long,
        type: ChronoUnit,
    ) {
        this.startTime = this.startTime.plus(time, type)
    }

    fun plusEndTime(
        time: Long,
        type: ChronoUnit,
    ) {
        this.endTime = this.endTime.plus(time, type)
    }
}
