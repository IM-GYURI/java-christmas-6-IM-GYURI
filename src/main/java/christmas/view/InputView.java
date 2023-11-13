package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.OrderDetail;
import christmas.util.OrderOrganizer;
import java.util.Map;

public class InputView {
    private static final int FIRST_DATE = 1;
    private static final int FINAL_DATE = 31;
    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String READ_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String READ_ORDER = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private int selectedDate;

    public int readDate() {
        System.out.println(START_MESSAGE);
        System.out.println(READ_DATE);
        String input = Console.readLine();
        selectedDate = convertInputWithDateValidation(input, DATE_ERROR_MESSAGE);
        return selectedDate;
    }

    private int convertInputWithDateValidation(String input, String errorMessage) {
        try {
            int inputConvert = Integer.parseInt(input);
            if (isInDateRange(inputConvert)) {
                return inputConvert;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
        return 0;
    }

    private boolean isInDateRange(int input) {
        if(input >= FIRST_DATE && input <= FINAL_DATE) {
            return true;
        } throw new IllegalArgumentException(DATE_ERROR_MESSAGE);
    }

    public Map<String, Integer> readOrder() {
        System.out.println(READ_ORDER);
        String input = Console.readLine();
        String[] split = input.split(",");

        OrderDetail orderDetail = new OrderDetail();
        OrderOrganizer.organizeOrder(split, orderDetail);

        return orderDetail.getOrderMap();
    }
}
