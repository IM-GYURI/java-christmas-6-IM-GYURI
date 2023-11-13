package christmas.util;

public class TotalPriceValidator {
    public static boolean isEventApplicable(int totalPrice) {
        return totalPrice >= 10000;
    }
}