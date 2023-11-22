package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.OrderController;

public class Application {
    private static final String ERROR = "[ERROR] ";
    public static void main(String[] args) {
        try {
            OrderController eventController = new OrderController();
            eventController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR  + e.getMessage());
        } finally {
            Console.close();
        }
    }
}
