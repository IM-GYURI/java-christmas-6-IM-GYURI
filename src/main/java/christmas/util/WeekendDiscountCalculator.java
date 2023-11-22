package christmas.util;

import christmas.domain.Menu;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class WeekendDiscountCalculator {
    private static final int mainDiscountPerItem = 2023;

    public static int calculateWeekendDiscount(LocalDate currentDate, Map<String, Integer> orderMap) {
        if (isWeekendEvent(currentDate)) {
            int mainDiscount = orderMap.entrySet().stream()
                    .filter(entry -> isMainMenu(entry.getKey()))
                    .mapToInt(entry -> entry.getValue() * mainDiscountPerItem)
                    .sum();

            return mainDiscount;
        }
        return 0;
    }

    private static boolean isWeekendEvent(LocalDate currentDate) {
        return EventPeriodValidator.isEventPeriod(currentDate) &&
                (currentDate.getDayOfWeek() == DayOfWeek.FRIDAY || currentDate.getDayOfWeek() == DayOfWeek.SATURDAY);
    }

    private static boolean isMainMenu(String menuName) {
        return Menu.getMenu().stream()
                .anyMatch(category -> category.containsMainMenu(menuName) && "<메인>".equals(category.getCategoryName()));
    }
}