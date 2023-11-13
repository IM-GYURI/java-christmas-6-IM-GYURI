package christmas.util;

import java.util.Map;

public class MenuQuantityValidator {
    private static final int MAX_MENU_QUANTITY = 20;

    public static boolean isOrderWithinLimit(Map<String, Integer> orderMap) {
        int totalQuantity = orderMap.values().stream().mapToInt(Integer::intValue).sum();
        return totalQuantity <= MAX_MENU_QUANTITY;
    }
}