package io.soboro.supreme.api.controller.v1.request

import io.soboro.supreme.api.domain.ExampleData

data class ExampleRequestDto(
    val data: String,
) {
    fun toExampleData(): ExampleData {
        return ExampleData(data, data)
    }
}
