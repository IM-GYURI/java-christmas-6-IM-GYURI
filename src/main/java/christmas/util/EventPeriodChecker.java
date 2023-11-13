package christmas.util;

import java.time.LocalDate;

public class EventPeriodChecker {
    private static final LocalDate EVENT_START_DATE = LocalDate.of(2023, 12, 1);
    private static final LocalDate EVENT_END_DATE = LocalDate.of(2023, 12, 31);

    public static boolean isEventPeriod(LocalDate currentDate) {
        return !currentDate.isBefore(EVENT_START_DATE) && !currentDate.isAfter(EVENT_END_DATE);
    }
}
