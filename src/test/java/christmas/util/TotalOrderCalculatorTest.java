package christmas.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.MenuCategory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TotalOrderCalculatorTest {
    @Test
    void 전체_주문가격_계산() {
        List<MenuCategory> menu = createTestMenu();
        Map<String, Integer> orderMap = createTestOrderMap();

        int totalPrice = TotalOrderCalculator.calculateTotalPrice(orderMap, menu);

        assertEquals(209000, totalPrice);
    }

    private List<MenuCategory> createTestMenu() {
        MenuCategory mainCategory = new MenuCategory("<메인>");
        mainCategory.addItem("티본스테이크", 55000);
        mainCategory.addItem("바비큐립", 54000);

        MenuCategory dessertCategory = new MenuCategory("<디저트>");
        dessertCategory.addItem("초코케이크", 15000);
        dessertCategory.addItem("아이스크림", 5000);

        return Arrays.asList(mainCategory, dessertCategory);
    }

    private Map<String, Integer> createTestOrderMap() {
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("티본스테이크", 2);
        orderMap.put("바비큐립", 1);
        orderMap.put("초코케이크", 3);

        return orderMap;
    }
}