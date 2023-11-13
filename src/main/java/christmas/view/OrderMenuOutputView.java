package christmas.view;

import christmas.domain.MenuCategory;
import christmas.util.TotalOrderCalculator;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OrderMenuOutputView {
    public void printMenu(Map<String, Integer> orderMap) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            String menu = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(menu + " " + quantity + "개");
        }
        System.out.println();
    }

    public void printTotalPrice(Map<String, Integer> orderMap, List<MenuCategory> menu) {
        int totalPrice = TotalOrderCalculator.calculateTotalPrice(orderMap, menu);
        DecimalFormat df = new DecimalFormat("###,###");
        String formatPrice = df.format(totalPrice);
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatPrice + "원");
        System.out.println();
    }
}
