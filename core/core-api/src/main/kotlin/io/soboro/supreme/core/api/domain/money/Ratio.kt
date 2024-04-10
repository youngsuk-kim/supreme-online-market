package io.soboro.supreme.core.api.domain.money

class Ratio internal constructor(private val rate: Double) {
    fun of(price: Money) = price.times(rate)

    companion object {
        fun valueOf(rate: Double) = Ratio(rate)
    }
}
