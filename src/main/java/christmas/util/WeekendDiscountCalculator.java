package christmas.util;

import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.MenuItem;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class WeekendDiscountCalculator {
    public static int calculateWeekendDiscount(LocalDate currentDate, Map<String, Integer> orderMap) {
        if (EventPeriodChecker.isEventPeriod(currentDate) && (currentDate.getDayOfWeek() == DayOfWeek.FRIDAY || currentDate.getDayOfWeek() == DayOfWeek.SATURDAY)) {
            int mainDiscountPerItem = 2023;

            int mainDiscount = orderMap.entrySet().stream()
                    .filter(entry -> isMainMenu(entry.getKey()))
                    .mapToInt(entry -> entry.getValue() * mainDiscountPerItem)
                    .sum();

            return mainDiscount;
        }

        return 0;
    }

    private static boolean isMainMenu(String menuName) {
        List<MenuCategory> menu = Menu.getMenu();
        for (MenuCategory category : menu) {
            for (MenuItem item : category.getItems()) {
                if (item.getName().equals(menuName) && category.getCategoryName().equals("<메인>")) {
                    return true;
                }
            }
        }
        return false;
    }
}