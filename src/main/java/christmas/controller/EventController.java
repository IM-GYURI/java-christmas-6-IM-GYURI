package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventController {
    public void start() {
        int date;
        Map<String, Integer> orderMap;

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        date = inputView.readDate();
        orderMap = inputView.readOrder();


        outputView.printEventPreview(date, orderMap);
        System.out.println();
        outputView.printMenu(orderMap);
    }
}
