package christmas.util;

import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.MenuItem;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class WeekdayDiscountCalculator {
    public static int calculateWeekdayDiscount(LocalDate currentDate, Map<String, Integer> orderMap) {
        if (EventPeriodChecker.isEventPeriod(currentDate) && isWeekday(currentDate)) {
            int dessertDiscountPerItem = 2023;

            int dessertDiscount = orderMap.entrySet().stream()
                    .filter(entry -> isDessertMenu(entry.getKey()))
                    .mapToInt(entry -> entry.getValue() * dessertDiscountPerItem)
                    .sum();

            return dessertDiscount;
        }

        return 0;
    }

    private static boolean isWeekday(LocalDate currentDate) {
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    private static boolean isDessertMenu(String menuName) {
        List<MenuCategory> menu = Menu.getMenu();
        for (MenuCategory category : menu) {
            for (MenuItem item : category.getItems()) {
                if (item.getName().equals(menuName) && category.getCategoryName().equals("<디저트>")) {
                    return true;
                }
            }
        }
        return false;
    }
}