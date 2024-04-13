package io.soboro.supreme.core.application

import io.soboro.supreme.core.model.order.Cart
import io.soboro.supreme.core.model.order.OrderItemRepository
import io.soboro.supreme.core.model.order.OrderRepository
import io.soboro.supreme.core.model.order.entity.Order
import io.soboro.supreme.core.model.order.entity.OrderItem
import io.soboro.supreme.core.model.order.entity.OrderOption
import io.soboro.supreme.core.model.shipment.Shipment
import io.soboro.supreme.core.model.shipment.ShipmentRepository
import io.soboro.supreme.core.model.shipment.Shipping
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val shipmentRepository: ShipmentRepository
) {

    @Transactional
    fun place(cart: Cart, shipping: Shipping) {
        val order = Order.create(cart.userId)
        orderRepository.save(order)

        val orderItems = cart.cartOptionGroups.map { toOrderItem(it, order) }
        orderItemRepository.saveAll(orderItems)

        val shipment = Shipment(
            orderId = order.id!!,
            shipping = shipping,
        )

        shipmentRepository.save(shipment)
    }

    private fun toOrderItem(cartOptionGroups: Cart.CartOptionGroup, order: Order): OrderItem {
        return OrderItem(
            order = order,
            productName = cartOptionGroups.productName,
            productCount = cartOptionGroups.count,
            orderOption = cartOptionGroups.options.map { toOrderOption(it) }
        )
    }

    private fun toOrderOption(cartOptionItem: Cart.CartOptionItem): OrderOption {
        return OrderOption(
            orderItemId = cartOptionItem.orderItemId,
            option = cartOptionItem.option,
            optionName = cartOptionItem.optionName,
        )
    }
}
