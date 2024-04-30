package io.soboro.supreme.persistence.rdbms.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["io.soboro.supreme.core.model"])
@EnableJpaRepositories(basePackages = ["io.soboro.supreme.persistence.rdbms.jpa"])
internal class JpaConfig
