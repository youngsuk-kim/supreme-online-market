package io.soboro.supreme.core.application

import io.soboro.supreme.core.model.common.Money
import io.soboro.supreme.core.model.order.Cart
import io.soboro.supreme.core.model.order.OrderRepository
import io.soboro.supreme.core.model.order.entity.Order
import io.soboro.supreme.core.model.order.entity.OrderItem
import io.soboro.supreme.core.model.shipment.Shipment
import io.soboro.supreme.core.model.shipment.ShipmentRepository
import io.soboro.supreme.core.model.shipment.Shipping
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val shipmentRepository: ShipmentRepository
) {

    @Transactional
    fun place(cart: Cart, shipping: Shipping) {
        val order = Order(
            userId = cart.userId,
            items = cart.cartItems.map(this::toOrderItem),
        )

        val shipment = Shipment(
            orderId = order.id!!,
            shipping = shipping,
            amount = Money.won(3000)
        )

        orderRepository.save(order)
        shipmentRepository.save(shipment)
    }

    private fun toOrderItem(cartOptionItem: Cart.CartOptionItem): OrderItem {
        return OrderItem(
            productName = cartOptionItem.name,
            productCount = cartOptionItem.count,
            productPrice = Money(cartOptionItem.price)
        )
    }
}
