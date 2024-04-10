package io.soboro.supreme.core.model.product.entity

import io.soboro.supreme.core.model.BaseEntity
import jakarta.persistence.Entity
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Entity
class TimeLimit(
    var startTime: LocalDateTime,
    var endTime: LocalDateTime,
) : BaseEntity() {
    companion object {
        fun create(
            startTime: LocalDateTime,
            endTime: LocalDateTime,
        ): TimeLimit {
            return TimeLimit(
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
