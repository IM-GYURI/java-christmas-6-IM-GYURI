package christmas.util;

import christmas.domain.MenuCategory;
import christmas.domain.MenuItem;
import java.util.List;
import java.util.Map;

public class BeverageValidator {

    public static boolean containsOnlyBeverages(Map<String, Integer> orderMap, List<MenuCategory> menu) {
        for (String menuName : orderMap.keySet()) {
            boolean isBeverage = isBeverage(menuName, menu);
            if (!isBeverage) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBeverage(String menuName, List<MenuCategory> menu) {
        for (MenuCategory category : menu) {
            for (MenuItem item : category.getItems()) {
                if (item.getName().equals(menuName) && category.getCategoryName().equals("<음료>")) {
                    return true;
                }
            }
        }
        return false;
    }
}