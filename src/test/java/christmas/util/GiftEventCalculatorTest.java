package christmas.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GiftEventCalculatorTest {
    @Test
    void 주문금액_120000_이상일_때_샴페인_1병_증정() {
        int totalOrderAmount = 130_000;
        Map<String, Integer> orderMap = new HashMap<>();

        int champagneGift = GiftEventCalculator.calculateChampagneGift(totalOrderAmount, orderMap);

        assertEquals(1, champagneGift);
        assertEquals(1, orderMap.get("샴페인"));
    }

    @Test
    void 주문금액_120000_미만일_때_샴페인_증정_X() {
        int totalOrderAmount = 110_000;
        Map<String, Integer> orderMap = new HashMap<>();

        int champagneGift = GiftEventCalculator.calculateChampagneGift(totalOrderAmount, orderMap);

        assertEquals(0, champagneGift);
        assertEquals(0, orderMap.getOrDefault("샴페인", 0));
    }
}