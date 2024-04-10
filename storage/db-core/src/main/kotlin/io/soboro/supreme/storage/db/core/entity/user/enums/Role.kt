package io.soboro.supreme.storage.db.core.entity.user.enums

enum class Role(private val authority: String) {
    USER("USER"),
    ADMIN("ADMIN"),
    ;

    override fun toString(): String {
        return authority
    }
}
