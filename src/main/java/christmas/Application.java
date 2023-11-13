package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.EventController;

public class Application {
    private static final String ERROR = "[ERROR] ";
    public static void main(String[] args) {
        try {
            EventController eventController = new EventController();
            eventController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR  + e.getMessage());
        } finally {
            Console.close();
        }
    }
}
