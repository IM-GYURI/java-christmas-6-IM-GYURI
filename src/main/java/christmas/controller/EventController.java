package christmas.controller;

import static christmas.domain.Menu.createMenu;

import christmas.domain.MenuCategory;
import christmas.util.OrderCalculator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;
import java.util.Map;

public class EventController {

    private InputView inputView;
    private OutputView outputView;
    private int date;
    private List<MenuCategory> menu = createMenu();
    private Map<String, Integer> orderMap;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        date = inputView.readDate();
        orderMap = inputView.readOrder();

        outputView.printEventPreview(date);
        outputView.printMenu(orderMap);
        outputView.printTotalPrice(orderMap, menu);
    }
}
