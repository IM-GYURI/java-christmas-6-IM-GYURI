package christmas.util;

import java.util.HashMap;
import java.util.Map;

public class OrderOrganizer {
    private static final String[] VALID_MENU_ITEMS
            = {"양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립", "해산물파스타",
            "크리스마스파스타", "초코케이크", "아이스크림", "제로콜라", "레드와인", "샴페인"};
    private static final String INVALID_ORDER_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public static void organizeOrder(String[] split, Map<String, Integer> orderMap) {
        Map<String, Integer> tempOrderMap = new HashMap<>();

        for (String item : split) {
            String[] itemDetails = item.split("-");
            if (itemDetails.length != 2) {
                handleInvalidInput(INVALID_ORDER_ERROR_MESSAGE);
                return;
            }

            String menu = itemDetails[0].trim();
            try {
                int quantity = Integer.parseInt(itemDetails[1].trim());
                validateAndAddToOrderMap(menu, quantity, orderMap);
            } catch (NumberFormatException e) {
                handleInvalidInput(INVALID_ORDER_ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                handleInvalidInput(INVALID_ORDER_ERROR_MESSAGE);
            }
        }

        for (Map.Entry<String, Integer> entry : tempOrderMap.entrySet()) {
            String menu = entry.getKey();
            int quantity = entry.getValue();

            if (orderMap.containsKey(menu)) {
                handleInvalidInput("[ERROR] 중복된 메뉴가 있습니다: " + menu);
                return;
            }

            orderMap.put(menu, quantity);
        }
    }

    private static void validateAndAddToOrderMap(String menu, int quantity, Map<String, Integer> orderMap) {
        if (!isValidMenu(menu)) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR_MESSAGE);
        }

        if (quantity < 1) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR_MESSAGE);
        }

        orderMap.put(menu, quantity);
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
        System.out.println(errorMessage);
    }
}
