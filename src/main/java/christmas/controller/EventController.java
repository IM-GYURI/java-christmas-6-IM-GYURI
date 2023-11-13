package christmas.controller;

import static christmas.domain.Menu.createMenu;

import christmas.domain.MenuCategory;
import christmas.util.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class EventController {
    private static final int CHAMPAGNE_PRICE = 25_000;
    private boolean isEventApplicable;
    private int date;
    private int totalPrice;
    private String badge;
    private List<MenuCategory> menu = createMenu();
    private Map<String, Integer> orderMap;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private TotalOrderCalculator orderCalculator = new TotalOrderCalculator();

    public void start() {
        processOrder();
    }

    private void processOrder() {
        date = inputView.readDate();
        orderMap = inputView.readOrder();
        totalPrice = orderCalculator.calculateTotalPrice(orderMap, menu);

        outputView.printEventPreview(date);
        outputView.printMenu(orderMap);

        if (isBeverageOnlyOrder()) {
            outputView.printBeverageOnlyMessage();
            return;
        }

        if (!isOrderWithinLimit()) {
            OutputView.printMenuQuantityLimitExceeded();
            return;
        }

        outputView.printTotalPrice(orderMap, menu);

        handleEventDetails();
    }

    private boolean isBeverageOnlyOrder() {
        return BeverageValidator.containsOnlyBeverages(orderMap, menu);
    }

    private boolean isOrderWithinLimit() {
        return MenuQuantityValidator.isOrderWithinLimit(orderMap);
    }

    private void handleEventDetails() {
        boolean isEventApplicable = TotalPriceValidator.isEventApplicable(totalPrice);
        if (isEventApplicable) {
            printEventDetails();
        }
        printEventNotApplicableDetails(isEventApplicable);
    }


    private void printEventDetails() {
        LocalDate localDate = LocalDateConverter.convertToLocalDate(date);
        int christmasDiscount = DDayDiscountCalculator.calculateChristmasDiscount(date);
        int weekdayDiscount = WeekdayDiscountCalculator.calculateWeekdayDiscount(localDate, orderMap);
        int weekendDiscount = WeekendDiscountCalculator.calculateWeekendDiscount(localDate, orderMap);
        int specialDiscount = SpecialDiscountCalculator.calculateSpecialDiscount(localDate, totalPrice);
        int champagneGift = GiftEvent.calculateChampagneGift(totalPrice, orderMap);

        outputView.printGiftEvent(champagneGift);
        outputView.printBenefits(christmasDiscount, weekdayDiscount, weekendDiscount, specialDiscount, champagneGift);

        int totalBenefits = christmasDiscount + weekdayDiscount + weekendDiscount + specialDiscount + (CHAMPAGNE_PRICE * champagneGift);
        outputView.printTotalBenefits(totalBenefits);

        int discountedTotalPrice = totalPrice - (totalBenefits - (CHAMPAGNE_PRICE * champagneGift));
        outputView.printDiscountedTotalPrice(discountedTotalPrice);

        badge = BadgeCalculator.calculateBadge(totalBenefits);
        outputView.printEventBadge(badge);
    }

    private void printEventNotApplicableDetails(boolean isEventApplicable) {
        if (!isEventApplicable) {
            outputView.printEventApplicableMessage();
            outputView.printGiftEvent(0);
            outputView.printBenefits(0, 0, 0, 0, 0);
            outputView.printTotalBenefits(0);
            outputView.printDiscountedTotalPrice(totalPrice);
            outputView.printEventBadge("없음");
        }
    }
}