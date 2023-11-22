package christmas.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class SpecialDiscountCalculatorTest {
    @Test
    void 특별할인이_적용되는_날짜인_경우() {
        LocalDate starDate = LocalDate.of(2023, 12, 10);

        int discountAmount = SpecialDiscountCalculator.calculateSpecialDiscount(starDate);

        assertEquals(1000, discountAmount);
    }

    @Test
    void 특별할인이_적용되지_않는_날짜인_경우() {
        LocalDate nonStarDate = LocalDate.of(2023, 12, 15);

        int discountAmount = SpecialDiscountCalculator.calculateSpecialDiscount(nonStarDate);

        assertEquals(0, discountAmount);
    }

    @Test
    void 이벤트_기간이고_특별할인이_적용되는_날짜인_경우() {
        LocalDate eventStarDate = LocalDate.of(2023, 12, 3);

        int discountAmount = SpecialDiscountCalculator.calculateSpecialDiscount(eventStarDate);

        assertEquals(1000, discountAmount);
    }

    @Test
    void 이벤트_기간이지만_특별할인이_적용되지_않는_날짜인_경우() {
        LocalDate eventNonStarDate = LocalDate.of(2023, 12, 5);

        int discountAmount = SpecialDiscountCalculator.calculateSpecialDiscount(eventNonStarDate);

        assertEquals(0, discountAmount);
    }

    @Test
    void 이벤트_기간이_아닌_날짜인_경우() {
        LocalDate nonEventDate = LocalDate.of(2023, 11, 30);

        int discountAmount = SpecialDiscountCalculator.calculateSpecialDiscount(nonEventDate);

        assertEquals(0, discountAmount);
    }
}