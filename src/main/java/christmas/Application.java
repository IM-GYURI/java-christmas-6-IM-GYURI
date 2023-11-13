package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.EventController;

public class Application {
    public static void main(String[] args) {
        try {
            EventController eventController = new EventController();
            eventController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            Console.close();
        }
    }
}
