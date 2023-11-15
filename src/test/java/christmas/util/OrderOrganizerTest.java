package christmas.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.domain.OrderDetail;
import org.junit.jupiter.api.Test;

class OrderOrganizerTest {
    @Test
    void 주문_정리_테스트() {
        OrderDetail orderDetail = new OrderDetail();
        String[] orderItems = {"양송이수프-2", "초코케이크-1", "레드와인-3"};

        OrderOrganizer.organizeOrder(orderItems, orderDetail);

        assertEquals(2, orderDetail.getOrderMap().get("양송이수프"));
        assertEquals(1, orderDetail.getOrderMap().get("초코케이크"));
        assertEquals(3, orderDetail.getOrderMap().get("레드와인"));
    }

    @Test
    void 유효하지_않은_주문인_경우() {
        OrderDetail orderDetail = new OrderDetail();
        String[] invalidOrderItems = {"치킨-2", "사이다-1"};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderOrganizer.organizeOrder(invalidOrderItems, orderDetail));

        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", exception.getMessage());
        assertTrue(orderDetail.getOrderMap().isEmpty());
    }

    @Test
    void 주문_수량이_유효하지_않은_경우() {
        OrderDetail orderDetail = new OrderDetail();
        String[] invalidQuantityItems = {"양송이수프-0", "초코케이크-3"};

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderOrganizer.organizeOrder(invalidQuantityItems, orderDetail));

        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", exception.getMessage());
        assertTrue(orderDetail.getOrderMap().isEmpty());
    }
}