package christmas.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class WeekendDiscountCalculatorTest {
    @Test
    void 주말_이벤트_메인_할인_적용_테스트() {
        LocalDate currentDate = LocalDate.of(2023, 12, 1); // 금요일
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("티본스테이크", 1);
        orderMap.put("바비큐립", 2);

        int discountAmount = WeekendDiscountCalculator.calculateWeekendDiscount(currentDate, orderMap);

        assertEquals(6069, discountAmount);
    }

    @Test
    void 주말_이벤트_메인_할인_미적용_테스트() {
        LocalDate currentDate = LocalDate.of(2023, 12, 2); // 토요일
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("초코케이크", 2);
        orderMap.put("아이스크림", 1);

        int discountAmount = WeekendDiscountCalculator.calculateWeekendDiscount(currentDate, orderMap);

        assertEquals(0, discountAmount);
    }
}