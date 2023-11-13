package christmas.util;

import java.time.LocalDate;
import java.util.Set;

public class SpecialDiscountCalculator {
    private static final Set<Integer> STAR_DATES = Set.of(3, 10, 17, 24, 25, 31);
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;
    private static final LocalDate EVENT_START_DATE = LocalDate.of(2023, 12, 1);
    private static final LocalDate EVENT_END_DATE = LocalDate.of(2023, 12, 31);

    public static int calculateSpecialDiscount(LocalDate currentDate, int totalOrderAmount) {
        if (isEventPeriod(currentDate) && STAR_DATES.contains(currentDate.getDayOfMonth())) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private static boolean isEventPeriod(LocalDate currentDate) {
        return !currentDate.isBefore(EVENT_START_DATE) && !currentDate.isAfter(EVENT_END_DATE);
    }
}
