package christmas.util;

import christmas.domain.OrderDetail;

public class OrderOrganizer {
    private static final String[] VALID_MENU_ITEMS
            = {"양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타",
            "크리스마스파스타", "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인"};
    private static final String INVALID_ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public static void organizeOrder(String[] split, OrderDetail orderDetail) {
        for (String item : split) {
            String[] itemDetails = item.split("-");
            if (itemDetails.length != 2 || !validateAndAddToOrderMap(itemDetails, orderDetail)) {
                handleInvalidInput(INVALID_ORDER_ERROR_MESSAGE);
                return;
            }
        }
    }

    private static boolean validateAndAddToOrderMap(String[] itemDetails, OrderDetail orderDetail) {
        String menu = itemDetails[0].trim();
        String quantityString = itemDetails[1].trim();

        try {
            int quantity = parseQuantity(quantityString);
            if (isValidMenu(menu) && quantity >= 1) {
                orderDetail.addMenu(menu, quantity);
                return true;
            }
        } catch (IllegalArgumentException ignored) {
        }

        return false;
    }

    private static int parseQuantity(String quantityString) {
        return Integer.parseInt(quantityString);
    }

    private static boolean isValidMenu(String menu) {
        for (String validItem : VALID_MENU_ITEMS) {
            if (validItem.equals(menu)) {
                return true;
            }
        }
        return false;
    }

    private static void handleInvalidInput(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}