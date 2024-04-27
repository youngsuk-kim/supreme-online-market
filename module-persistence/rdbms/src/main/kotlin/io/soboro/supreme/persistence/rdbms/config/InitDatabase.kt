package io.soboro.supreme.persistence.rdbms.config

import io.soboro.supreme.core.model.common.Address
import io.soboro.supreme.core.model.common.Money
import io.soboro.supreme.core.model.product.entity.Product
import io.soboro.supreme.core.model.product.entity.ProductImage
import io.soboro.supreme.core.model.product.entity.ProductOptionGroup
import io.soboro.supreme.core.model.product.entity.ProductOptionItem
import io.soboro.supreme.core.model.product.enums.OptionTitle
import io.soboro.supreme.core.model.product.repository.ProductRepository
import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.core.model.user.entity.UserSecret
import io.soboro.supreme.core.model.user.repository.UserRepository
import io.soboro.supreme.core.model.user.vo.Email
import io.soboro.supreme.core.model.user.vo.Password
import io.soboro.supreme.core.model.user.vo.PhoneNumber
import io.soboro.supreme.core.support.PasswordEncoder
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import kotlin.random.Random

@Component
class InitDatabase(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val productRepository: ProductRepository,
) {

    @PostConstruct
    @Transactional
    fun init() {
        val user = User.create(
            username = "test",
            address = Address("서울시", "강남구", "비싸 오피스텔"),
            userSecret = UserSecret(
                Email("thayer@naver.com"),
                PhoneNumber("01053092392"),
                Password(passwordEncoder.encode("1234")),
            ),
        )

        userRepository.save(user)

        saveProducts()
    }

    fun saveProducts() {
        val products = mutableListOf<Product>()

        for (i in 1..10) {
            val images = listOf(
                ProductImage(
                    url = "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/63193ad7-3dcb-4ef9-a242-77126431b022/%EC%97%90%EC%96%B4-%EC%A1%B0%EB%8D%98-1-%EC%97%98%EB%A6%AC%EB%B2%A0%EC%9D%B4%ED%8A%B8-%EB%A1%9C%EC%9A%B0-%EC%97%AC%EC%84%B1-%EC%8B%A0%EB%B0%9C-fMD68li7.png",
                    sequence = i,
                    description = "Nike Shoe Model $i",
                ),
            )

            val optionItems = listOf(
                ProductOptionItem(
                    optionName = "Size",
                    optionTitle = OptionTitle.SIZE,
                ),
            )

            // Create the product instance first without the option group
            val product = Product(
                productName = "Nike Shoe Model $i",
                brandName = "Nike",
                description = "A high-quality Nike shoe",
                images = images,
                price = Money(BigDecimal(20000)),
                productOptionGroups = mutableListOf(),
            )

            // Create the option group with the product instance
            val optionGroup = ProductOptionGroup(
                product = product, // Pass the product here
                optionItems = optionItems,
                stock = Random.nextInt(50, 100),
            )

            product.productOptionGroups.add(optionGroup)

            productRepository.save(product)
        }
    }
}
