package christmas.view;

import christmas.domain.MenuCategory;
import christmas.util.TotalOrderCalculator;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final int MINUS = -1;
    private static final int CHAMPAGNE_PRICE = 25_000;

    public static void printEventPreview(int day) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

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

    public void printGiftEvent(int giftQuantity) {
        System.out.println("<증정 메뉴>");
        if (giftQuantity == 1) {
            System.out.println("샴페인 " + giftQuantity + "개");
        }
        if (giftQuantity == 0) {
            System.out.println("없음");
        }
        System.out.println();
    }

    public void printBenefits(int christmasDiscount, int weekdayDiscount, int weekendDiscount, int specialDiscount, int champagneGift) {
        System.out.println("<혜택 내역>");

        if (christmasDiscount > 0) {
            printDiscount("크리스마스 디데이 할인: ", (MINUS * christmasDiscount));
        }

        if (weekdayDiscount > 0) {
            printDiscount("평일 할인: ", (MINUS * weekdayDiscount));
        }

        if (weekendDiscount > 0) {
            printDiscount("주말 할인: ", (MINUS * weekendDiscount));
        }

        if (specialDiscount > 0) {
            printDiscount("특별 할인: ", (MINUS * specialDiscount));
        }

        if (champagneGift > 0) {
            printDiscount("증정 이벤트: ", (MINUS * CHAMPAGNE_PRICE * champagneGift));
        }

        if (christmasDiscount == 0 && weekdayDiscount == 0 && weekendDiscount == 0 && specialDiscount == 0 && champagneGift == 0) {
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printDiscount(String eventName, int discountAmount) {
        String formattedAmount = String.format("%,d", discountAmount);
        System.out.println(eventName + formattedAmount + "원");
    }

    public void printTotalBenefits(int totalBenefits) {
        System.out.printf("<총혜택 금액>\n%,d원\n\n", (MINUS*totalBenefits));
    }

    public void printDiscountedTotalPrice(int discountedTotalPrice) {
        System.out.printf("<할인 후 예상 결제 금액>\n%,d원\n", discountedTotalPrice);
        System.out.println();
    }

    public void printEventBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
