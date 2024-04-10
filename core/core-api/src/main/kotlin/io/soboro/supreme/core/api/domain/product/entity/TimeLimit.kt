package io.soboro.supreme.core.api.domain.product.entity

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class TimeLimit(
    val idx: Long? = null,
    var startTime: LocalDateTime,
    var endTime: LocalDateTime,
) {
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
