package io.soboro.supreme.core.support

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

@Component
class JsonUtility(private val objectMapper: ObjectMapper) {
    fun <T> toJson(data: T): String? {
        return try {
            objectMapper.writeValueAsString(data)
        } catch (e: JsonProcessingException) {
            println("Serialization error: ${e.message}")
            null
        }
    }

    fun <T> fromJson(json: String, clazz: Class<T>): T? {
        return try {
            objectMapper.readValue(json, clazz)
        } catch (e: JsonProcessingException) {
            println("Deserialization error: ${e.message}")
            null
        }
    }
}
