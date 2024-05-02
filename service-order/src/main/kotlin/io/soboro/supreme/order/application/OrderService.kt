package io.soboro.supreme.order.application

import io.soboro.supreme.order.domain.order.entity.Order
import io.soboro.supreme.order.domain.order.entity.OrderItem
import io.soboro.supreme.order.domain.order.repository.OrderItemRepository
import io.soboro.supreme.order.domain.order.repository.OrderRepository
import io.soboro.supreme.order.domain.order.vo.OrderUnit
import io.soboro.supreme.order.domain.shipment.entity.Shipment
import io.soboro.supreme.order.domain.shipment.repository.ShipmentRepository
import io.soboro.supreme.order.domain.shipment.vo.Shipping
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository,
    private val shipmentRepository: ShipmentRepository,
    private val authApi: AuthApi,
    private val productApi: ProductApi,
) {

    @Transactional
    suspend fun place(token: String, userId: Long, orderUnits: List<OrderUnit>, shipping: Shipping) {
        // 로그인이 된 유저인지
        val isLogin = authApi.isLogin(token)

        if (!isLogin) throw IllegalArgumentException("Token is invalid")

        // 재고가 남았는지
        val noStock = orderUnits.none { orderUnit ->
            productApi.isStockEnoughForSale(
                orderUnit.productId,
                orderUnit.sku,
                orderUnit.stock,
            )
        }
        if (noStock) throw IllegalStateException("No stock available for $userId")

        // 주문 생성
        val order = Order.create(userId)
        orderRepository.save(order)

        // 주문 상품 생성
        val orderItems = orderUnits.map { toOrderItem(it, order) }
        orderItemRepository.saveAll(orderItems)

        // 배송 생성
        val shipment = Shipment(
            order = order,
            shipping = shipping,
        )

        // 배송 저장
        shipmentRepository.save(shipment)
    }

    private fun toOrderItem(orderUnit: OrderUnit, order: Order): OrderItem {
        return OrderItem(
            order = order,
            sku = orderUnit.sku,
            quantity = orderUnit.stock,
            optionName = orderUnit.optionName,
            option = orderUnit.option,
        )
    }
}
