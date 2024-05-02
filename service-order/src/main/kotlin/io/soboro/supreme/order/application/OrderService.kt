package io.soboro.supreme.order.application

import io.soboro.supreme.order.domain.order.entity.Order
import io.soboro.supreme.order.domain.order.entity.OrderItem
import io.soboro.supreme.order.domain.order.repository.OrderItemRepository
import io.soboro.supreme.order.domain.order.repository.OrderRepository
import io.soboro.supreme.order.domain.order.vo.OrderUnit
import io.soboro.supreme.order.domain.shipment.entity.Shipment
import io.soboro.supreme.order.domain.shipment.repository.ShipmentRepository
import io.soboro.supreme.order.domain.shipment.vo.Shipping
import io.soboro.supreme.order.presentation.rest.error.ApiException
import io.soboro.supreme.order.presentation.rest.error.ErrorType
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
        // 로그인 확인
        val isLogin = authApi.isLogin(token)
        if (!isLogin) throw ApiException(ErrorType.AUTEHNTICATION_ERROR, "Token is invalid")

        // 재고 확인
        val noStock = orderUnits.any { orderUnit ->
            !productApi.isStockEnoughForSale(orderUnit.productId, orderUnit.sku, orderUnit.stock)
        }
        if (noStock) throw ApiException(ErrorType.INVALID_ARG_ERROR, "No stock available for $userId")

        // 주문 생성 및 저장
        val order = Order.create(userId)
        orderRepository.save(order)

        // 주문 상품 생성 및 저장
        orderUnits.map { toOrderItem(it, order.id!!) }
            .forEach { orderItemRepository.save(it) }

        // 배송 생성 및 저장
        val shipment = Shipment.create(orderId = order.id!!, shipping = shipping)
        shipmentRepository.save(shipment)
    }

    private fun toOrderItem(orderUnit: OrderUnit, orderId: Long): OrderItem {
        return OrderItem(
            orderId = orderId,
            sku = orderUnit.sku,
            quantity = orderUnit.stock,
            optionValue = orderUnit.optionName,
            optionKey = orderUnit.option.name,
        )
    }
}
