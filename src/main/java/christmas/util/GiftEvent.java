package christmas.util;

import java.util.Map;

public class GiftEvent {
    private static final int THRESHOLD_AMOUNT = 120_000;
    private static final String CHAMPAGNE_MENU = "샴페인";
    private static final int GIFT_QUANTITY = 1;

    public static int calculateChampagneGift(int totalOrderAmount, Map<String, Integer> orderMap) {
        int champagneGift = 0;
        if (totalOrderAmount >= THRESHOLD_AMOUNT) {
            orderMap.merge(CHAMPAGNE_MENU, GIFT_QUANTITY, Integer::sum);
            champagneGift = GIFT_QUANTITY;
        }
        return champagneGift;
    }
}