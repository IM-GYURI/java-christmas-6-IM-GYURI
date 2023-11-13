package christmas.util;


public class DDayDiscountCalculator {
    public static int calculateChristmasDiscount(int currentDate) {
        int startDate = 1;
        int endDate = 25;

        if (currentDate < startDate || currentDate > endDate) {
            return 0;
        }

        int initialDiscount = 1000;

        int daysBetween = currentDate - startDate;

        int discountAmount = initialDiscount + (daysBetween * 100);

        return discountAmount;
    }
}
