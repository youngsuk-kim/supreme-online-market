package io.soboro.supreme.order.application

import org.springframework.stereotype.Service

@Service
class PaymentService {

    /**
     * Pay
     *
     * - web hook doc (https://docs.tosspayments.com/guides/webhook#%EC%9D%B4%EB%B2%A4%ED%8A%B8-%ED%83%80%EC%9E%85-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0)
     *
     *
     * - 사용자 ID로 주문 조회
     * - 주문 내용 결제 요청 객체에 담기
     * - 결제 하기
     *
     * flow
     *
     * - 결제 요청
     * - 결제 승인 1단계 (pg)
     * - 결제 승인 2단계 (my server) -> web hook
     * - 결제 완료 -> redirect to 영수증
     *
     *
     * 결제 승인 설계
     *
     *  성공 케이스
     * - 웹훅이 엔드포인트에 들어온다.
     * - 필터에서 웹훅을 보낸 곳이 토스 ip 가 맞는지 확인한다.
     * - 맞으면 컨트롤러에 요청을 넘긴다.
     * - requst 객체에 담긴다.
     * - 토스에서 맞는 값이 넘어 왔는지 검증한다 (request 객체에서)
     * - 서비스로 order Id, 토스에서 받은 payment 객체를 넘긴다.
     * - order Id를 통해 주문 정보를 디비에서 가져온다 (최근 주문 성공한 유저)
     * - payment 객체와 비교해서 올바른지 확인한다.
     *
     *
     * - 주요 문제 해결
     * 1. 결제 주문 재고 동시성 문제 해결
     * 2. 선착순 동시성 문제 해결
     * 3. 성능 최적화
     * 4. 테스트 코드
     * 5. 클린 아키텍처
     *
     */
    fun pay() {
    }
}
