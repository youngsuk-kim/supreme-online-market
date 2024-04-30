package io.soboro.supreme.order.core.application

import io.soboro.supreme.order.core.model.order.entity.Order
import io.soboro.supreme.order.core.model.order.entity.OrderItem
import io.soboro.supreme.order.core.model.order.repository.OrderItemRepository
import io.soboro.supreme.order.core.model.order.repository.OrderRepository
import io.soboro.supreme.order.core.model.order.vo.OrderUnit
import io.soboro.supreme.order.core.model.shipment.entity.Shipment
import io.soboro.supreme.order.core.model.shipment.repository.ShipmentRepository
import io.soboro.supreme.order.core.model.shipment.vo.Shipping
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val shipmentRepository: ShipmentRepository,
) {

    @Transactional
    fun place(userId: Long, productUnits: List<OrderUnit>, shipping: Shipping) {
        val order = Order.create(userId)
        orderRepository.save(order)

        val orderItems = productUnits.map { toOrderItem(it, order) }
        orderItemRepository.saveAll(orderItems)

        val shipment = Shipment(
            orderId = order.id!!,
            shipping = shipping,
        )

        shipmentRepository.save(shipment)
    }

    private fun toOrderItem(productUnit: OrderUnit, order: Order): OrderItem {
        return OrderItem(
            order = order,
            sku = productUnit.sku,
            quantity = productUnit.stock,
            optionName = productUnit.optionName,
            option = productUnit.option,
        )
    }
}
