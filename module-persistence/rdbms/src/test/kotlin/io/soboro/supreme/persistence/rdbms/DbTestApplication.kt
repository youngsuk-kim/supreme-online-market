package io.soboro.supreme.persistence.rdbms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class CoreDbTestApplication

fun main(args: Array<String>) {
    runApplication<io.soboro.supreme.persistence.rdbms.CoreDbTestApplication>(*args)
}
