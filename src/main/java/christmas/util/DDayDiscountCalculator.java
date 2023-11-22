package christmas.util;

public class DDayDiscountCalculator {
    private static final int startDate = 1;
    private static final int endDate = 25;
    private static final int initialDiscount = 1000;

    public static int calculateChristmasDiscount(int currentDate) {
        if (currentDate < startDate || currentDate > endDate) {
            return 0;
        }

        int daysBetween = currentDate - startDate;

        int discountAmount = initialDiscount + (daysBetween * 100);

        return discountAmount;
    }
}
