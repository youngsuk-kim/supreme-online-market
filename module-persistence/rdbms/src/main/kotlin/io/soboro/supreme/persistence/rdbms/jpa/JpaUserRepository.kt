package io.soboro.supreme.persistence.rdbms.jpa

import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.repository.UserRepository
import org.springframework.data.jpa.repository.JpaRepository

interface JpaUserRepository : UserRepository, JpaRepository<User, Long>
