package io.soboro.supreme.storage.db.core.entity.money

class Ratio internal constructor(private val rate: Double) {
    fun of(price: Money) = price.times(rate)

    companion object {
        fun valueOf(rate: Double) = Ratio(rate)
    }
}
