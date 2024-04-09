package io.soboro.supreme.api.domain

import org.springframework.stereotype.Service

@Service
class ExampleService() {
    fun processExample(exampleData: ExampleData): io.soboro.supreme.api.domain.ExampleResult {
        return io.soboro.supreme.api.domain.ExampleResult(exampleData.value)
    }
}
