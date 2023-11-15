package christmas.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class WeekdayDiscountCalculatorTest {
    @Test
    void 주중_할인_적용_테스트() {
        LocalDate currentDate = LocalDate.of(2023, 12, 5); // 월요일
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("아이스크림", 2);
        orderMap.put("초코케이크", 1);

        int discountAmount = WeekdayDiscountCalculator.calculateWeekdayDiscount(currentDate, orderMap);

        assertEquals(6069, discountAmount);
    }

    @Test
    void 주말_할인_미적용_테스트() {
        LocalDate currentDate = LocalDate.of(2023, 12, 9); // 금요일
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("아이스크림", 2);
        orderMap.put("초코케이크", 1);

        int discountAmount = WeekdayDiscountCalculator.calculateWeekdayDiscount(currentDate, orderMap);

        assertEquals(0, discountAmount);
    }
}