package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L; //memberId 지정.
        Member member = new Member(memberId, "memberA", Grade.VIP);  //새로운 member 정보로 객체를 만듦.
        memberService.join(member); //윗줄에서 만든 memeber 객체를 호출함.

        Order order = orderService.createOrder(memberId, "itemA", 10000);   //memberId를 가져오고 상품과 가격정보로 주문을 넣음.
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);    //주문한 order가 실제로 1000원 할인 됐는지 검증한다.
    }
}
