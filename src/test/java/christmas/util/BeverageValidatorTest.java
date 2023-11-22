package christmas.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.domain.MenuCategory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class BeverageValidatorTest {
    @Test
    void 음료만_주문한_경우() {
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("레드와인", 1);
        orderMap.put("제로콜라", 2);

        List<MenuCategory> menu = Arrays.asList(
                createCategory("<메인>", "티본스테이크", 55_000, "바비큐립", 54_000),
                createCategory("<음료>", "제로콜라", 3_000, "레드와인", 60_000)
        );

        boolean result = BeverageValidator.containsOnlyBeverages(orderMap, menu);

        assertTrue(result);
    }

    @Test
    void 음료_이외의_메뉴도_주문한_경우() {
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("티본스테이크", 1);
        orderMap.put("레드와인", 2);

        List<MenuCategory> menu = Arrays.asList(
                createCategory("<메인>", "티본스테이크", 55_000, "바비큐립", 54_000),
                createCategory("<음료>", "제로콜라", 3_000, "레드와인", 60_000)
        );

        boolean result = BeverageValidator.containsOnlyBeverages(orderMap, menu);

        assertFalse(result);
    }

    private MenuCategory createCategory(String categoryName, Object... items) {
        MenuCategory category = new MenuCategory(categoryName);
        for (int i = 0; i < items.length; i += 2) {
            String itemName = (String) items[i];
            int price = (int) items[i + 1];
            category.addItem(itemName, price);
        }
        return category;
    }
}