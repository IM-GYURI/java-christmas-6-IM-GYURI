package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderDetailTest {
    private OrderDetail orderDetail;

    @BeforeEach
    void setUp() {
        orderDetail = new OrderDetail();
    }

    @Test
    void 주문상세에_메뉴_추가_확인() {
        String menu = "티본스테이크";
        int quantity = 2;

        orderDetail.addMenu(menu, quantity);
        Map<String, Integer> orderMap = orderDetail.getOrderMap();

        assertEquals(quantity, orderMap.get(menu));
    }

    @Test
    void 동일한_메뉴_여러_번_추가_확인() {
        String menu = "티본스테이크";
        int quantity = 2;

        orderDetail.addMenu(menu, quantity);
        orderDetail.addMenu(menu, quantity);

        Map<String, Integer> orderMap = orderDetail.getOrderMap();

        assertEquals(quantity * 2, orderMap.get(menu));
    }
}
