package christmas.view;

import christmas.domain.MenuCategory;
import christmas.util.TotalOrderCalculator;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printMenuQuantityLimitExceeded() {
        System.out.println("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
    }

    public static void printBeverageOnlyMessage() {
        System.out.println("음료만 주문 시, 주문할 수 없습니다.");
    }
}
