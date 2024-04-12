package io.soboro.supreme.persistence.rdbms.jpa

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@SpringBootTest
@ConfigurationPropertiesScan
@ActiveProfiles("local")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class CustomProductRepositoryImplTest {

    @Autowired
    private lateinit var repository: CustomProductRepositoryImpl

//    @Test
//    fun `products pagination`() {
//        repository.paginationNoOffsetBuilder(1L, "신발", 1L)
//    }
}