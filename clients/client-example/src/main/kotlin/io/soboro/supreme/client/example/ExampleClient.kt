package io.soboro.supreme.client.example

import io.soboro.supreme.client.ExampleApi
import io.soboro.supreme.client.ExampleClientResult
import io.soboro.supreme.client.model.ExampleRequestDto
import org.springframework.stereotype.Component

@Component
class ExampleClient internal constructor(
    private val exampleApi: ExampleApi,
) {
    fun example(exampleParameter: String): ExampleClientResult {
        val request = ExampleRequestDto(exampleParameter)
        return exampleApi.example(request).toResult()
    }
}
