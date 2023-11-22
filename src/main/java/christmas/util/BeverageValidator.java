package christmas.util;

import christmas.domain.MenuCategory;
import java.util.List;
import java.util.Map;

public class BeverageValidator {

    public static boolean containsOnlyBeverages(Map<String, Integer> orderMap, List<MenuCategory> menu) {
        return orderMap.keySet().stream().allMatch(menuName -> isBeverage(menuName, menu));
    }

    private static boolean isBeverage(String menuName, List<MenuCategory> menu) {
        return menu.stream()
                .filter(category -> category.getCategoryName().equals("<음료>"))
                .flatMap(category -> category.getItems().stream())
                .anyMatch(item -> item.getName().equals(menuName));
    }
}
