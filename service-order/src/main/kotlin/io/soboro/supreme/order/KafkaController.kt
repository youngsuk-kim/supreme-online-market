package io.soboro.supreme.order

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaController(private val kafkaProducer: KafkaProducer, private val kafkaConsumer: KafkaConsumer) {

    @PostMapping("/kafka")
    fun produce() {
        kafkaProducer.sendMessage("hi kafka")
    }
}
