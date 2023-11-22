package christmas.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BadgeCalculatorTest {
    @Test
    void 산타_배지_획득() {
        int totalBenefits = 25_000;

        String badge = BadgeCalculator.calculateBadge(totalBenefits);

        assertEquals("산타", badge);
    }

    @Test
    void 트리_배지_획득() {
        int totalBenefits = 10_000;

        String badge = BadgeCalculator.calculateBadge(totalBenefits);

        assertEquals("트리", badge);
    }

    @Test
    void 별_배지_획득() {
        int totalBenefits = 5_000;

        String badge = BadgeCalculator.calculateBadge(totalBenefits);

        assertEquals("별", badge);
    }

    @Test
    void 배지_없음() {
        int totalBenefits = 3_000;

        String badge = BadgeCalculator.calculateBadge(totalBenefits);

        assertEquals("없음", badge);
    }
}