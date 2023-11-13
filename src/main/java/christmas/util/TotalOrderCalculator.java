package christmas.util;

import christmas.domain.MenuCategory;
import christmas.domain.MenuItem;
import java.util.List;
import java.util.Map;

public class TotalOrderCalculator {
    public static int calculateTotalPrice(Map<String, Integer> orderMap, List<MenuCategory> menu) {
        int totalPrice = 0;

        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            String menuItemName = entry.getKey();
            int quantity = entry.getValue();

            for (MenuCategory category : menu) {
                for (MenuItem item : category.getItems()) {
                    if (item.getName().equals(menuItemName)) {
                        totalPrice += item.getPrice() * quantity;
                    }
                }
            }
        }
        return totalPrice;
    }
}
