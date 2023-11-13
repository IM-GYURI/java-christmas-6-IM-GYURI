package christmas.controller;

import static christmas.domain.Menu.createMenu;

import christmas.domain.MenuCategory;
import christmas.util.DDayDiscountCalculator;
import christmas.util.LocalDateConverter;
import christmas.util.SpecialDiscountCalculator;
import christmas.util.TotalOrderCalculator;
import christmas.util.WeekdayDiscountCalculator;
import christmas.util.WeekendDiscountCalculator;
import christmas.view.InputView;
import christmas.util.GiftEvent;
import christmas.view.OutputView;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class EventController {
    private static final int CHAMPANGE_PRICE = 25_000;
    private InputView inputView;
    private OutputView outputView;
    private int date;
    private int totalPrice;
    private TotalOrderCalculator orderCalculator;
    private List<MenuCategory> menu = createMenu();
    private Map<String, Integer> orderMap;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.orderCalculator = new TotalOrderCalculator();
    }

    public void start() {
        date = inputView.readDate();
        orderMap = inputView.readOrder();
        totalPrice = orderCalculator.calculateTotalPrice(orderMap, menu);

        outputView.printEventPreview(date);
        outputView.printMenu(orderMap);
        outputView.printTotalPrice(orderMap, menu);

        LocalDate localDate = LocalDateConverter.convertToLocalDate(date);

        int christmasDiscount = DDayDiscountCalculator.calculateChristmasDiscount(date);
        int weekdayDiscount = WeekdayDiscountCalculator.calculateWeekdayDiscount(localDate, orderMap);
        int weekendDiscount = WeekendDiscountCalculator.calculateWeekendDiscount(localDate, orderMap);
        int specialDiscount = SpecialDiscountCalculator.calculateSpecialDiscount(localDate, totalPrice);
        int champagneGift = GiftEvent.calculateChampagneGift(totalPrice, orderMap);

        outputView.printGiftEvent(champagneGift);

        outputView.printBenefits(christmasDiscount, weekdayDiscount, weekendDiscount, specialDiscount, champagneGift);

        int totalBenefits = christmasDiscount + weekdayDiscount + weekendDiscount + specialDiscount + (CHAMPANGE_PRICE*champagneGift);
        outputView.printTotalBenefits(totalBenefits);


        int discountedTotalPrice = totalPrice - totalBenefits;
        outputView.printDiscountedTotalPrice(discountedTotalPrice);
    }

}
