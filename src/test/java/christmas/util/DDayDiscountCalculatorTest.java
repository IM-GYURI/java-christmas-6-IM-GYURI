package christmas.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class DDayDiscountCalculatorTest {
    @Test
    void 크리스마스_이전_날짜인_경우_할인이_적용_X() {
        int currentDate = 0;

        int discountAmount = DDayDiscountCalculator.calculateChristmasDiscount(currentDate);

        assertEquals(0, discountAmount);
    }

    @Test
    void 크리스마스_당일인_경우_초기할인이_적용() {
        int currentDate = 25;

        int discountAmount = DDayDiscountCalculator.calculateChristmasDiscount(currentDate);

        assertEquals(3400, discountAmount);
    }

    @Test
    void 크리스마스_이후_날짜인_경우_할인이_적용_X() {
        int currentDate = 30;

        int discountAmount = DDayDiscountCalculator.calculateChristmasDiscount(currentDate);

        assertEquals(0, discountAmount);
    }
}