package io.soboro.supreme.order.core.model.order.validator

/**
 * 사용자가 주문 버튼 클릭시, 주문 정책에 맞는 값을
 * 올바르게 모두 입력 했는지 검증 하는 역할을 한다.
 */
object OrderValidator {
    /**
     * 구매 가능한 유저 인지 검증
     */
    fun noAuth() {
    }

    /**
     * 상품 구매 제한 시간 초과 검증
     */
    fun timeout() {
    }

    /**
     * 재고가 모두 소진 됐는지 검증
     */
    fun stockRunOut() {
    }

    /**
     * 주문 필수 정보 모두 입력 했는지 검증
     */
    fun fieldNotFullFilled() {
    }
}
