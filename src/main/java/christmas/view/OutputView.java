package christmas.view;

import java.util.Map;

public class OutputView {
    public static void printEventPreview(int day, Map<String, Integer> orderMap) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printMenu(Map<String, Integer> orderMap) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            String menu = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(menu + " " + quantity + "개");
        }
    }
}
