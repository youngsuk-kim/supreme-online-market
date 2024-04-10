package io.soboro.supreme.core.api.domain.user.enums

enum class Role(private val authority: String) {
    USER("USER"),
    ADMIN("ADMIN"),
    ;

    override fun toString(): String {
        return authority
    }
}
