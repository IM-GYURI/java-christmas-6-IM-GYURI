package christmas.util;

import christmas.domain.Menu;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class WeekdayDiscountCalculator {
    private static final int DESSERT_DISCOUNT_PER_ITEM = 2023;

    private interface MenuTypeChecker {
        boolean check(String menuName);
    }

    public static int calculateWeekdayDiscount(LocalDate currentDate, Map<String, Integer> orderMap) {
        if (EventPeriodValidator.isEventPeriod(currentDate) && isWeekday(currentDate)) {
            return calculateDiscount(orderMap, WeekdayDiscountCalculator::isDessertMenu, DESSERT_DISCOUNT_PER_ITEM);
        }
        return 0;
    }

    private static boolean isWeekday(LocalDate currentDate) {
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    private static boolean isDessertMenu(String menuName) {
        return Menu.isDessertMenuItem(menuName);
    }

    private static int calculateDiscount(Map<String, Integer> orderMap, MenuTypeChecker menuTypeChecker, int discountPerItem) {
        return orderMap.entrySet().stream()
                .filter(entry -> menuTypeChecker.check(entry.getKey()))
                .mapToInt(entry -> entry.getValue() * discountPerItem)
                .sum();
    }
}