package io.soboro.supreme

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class StoreApplication

fun main(args: Array<String>) {
    runApplication<StoreApplication>(*args)
}
