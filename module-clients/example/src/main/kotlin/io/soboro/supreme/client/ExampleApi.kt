package io.soboro.supreme.client

import io.soboro.supreme.client.model.ExampleRequestDto
import io.soboro.supreme.client.model.ExampleResponseDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(value = "example-api", url = "\${example.api.url}")
internal interface ExampleApi {
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/example/example-api"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun example(@RequestBody request: ExampleRequestDto): ExampleResponseDto
}
