package christmas.util;

public class BadgeCalculator {
    private static final int STAR_THRESHOLD = 5000;
    private static final int TREE_THRESHOLD = 10000;
    private static final int SANTA_THRESHOLD = 20000;

    public static String calculateBadge(int totalBenefits) {
        String badge = "없음";

        if (totalBenefits >= SANTA_THRESHOLD) {
            badge = "산타";
        } else if (totalBenefits >= TREE_THRESHOLD) {
            badge = "트리";
        } else if (totalBenefits >= STAR_THRESHOLD) {
            badge = "별";
        }

        return badge;
    }
}
