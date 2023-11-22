package christmas.view;

public class BenefitsOutputView {
    private static final int MINUS = -1;
    private static final int CHAMPAGNE_PRICE = 25_000;

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

        printDiscountIfPositive("크리스마스 디데이 할인: ", christmasDiscount);
        printDiscountIfPositive("평일 할인: ", weekdayDiscount);
        printDiscountIfPositive("주말 할인: ", weekendDiscount);
        printDiscountIfPositive("특별 할인: ", specialDiscount);
        printDiscountIfPositive("증정 이벤트: ", CHAMPAGNE_PRICE * champagneGift);

        if (allDiscountsAreZero(christmasDiscount, weekdayDiscount, weekendDiscount, specialDiscount, champagneGift)) {
            System.out.println("없음");
        }

        System.out.println();
    }

    private void printDiscountIfPositive(String eventName, int discountAmount) {
        if (discountAmount > 0) {
            printDiscount(eventName, MINUS * discountAmount);
        }
    }

    private boolean allDiscountsAreZero(int... discounts) {
        for (int discount : discounts) {
            if (discount != 0) {
                return false;
            }
        }
        return true;
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
}
