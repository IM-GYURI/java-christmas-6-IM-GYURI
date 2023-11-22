package christmas.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TotalPriceValidatorTest {
    @Test
    void 이벤트_적용가능한_경우() {
        int totalPrice = 15000;

        boolean isApplicable = TotalPriceValidator.isEventApplicable(totalPrice);

        assertTrue(isApplicable);
    }

    @Test
    void 이벤트_적용불가능한_경우() {
        int totalPrice = 8000;

        boolean isApplicable = TotalPriceValidator.isEventApplicable(totalPrice);

        assertFalse(isApplicable);
    }
}