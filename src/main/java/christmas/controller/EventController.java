package christmas.controller;

import static christmas.domain.Menu.createMenu;

import christmas.domain.MenuCategory;
import christmas.util.*;
import christmas.view.BenefitsOutputView;
import christmas.view.EventOutputView;
import christmas.view.InputView;
import christmas.view.OrderMenuOutputView;
import christmas.view.MessageOutputView;

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
    private MessageOutputView messageOutputView = new MessageOutputView();
    private EventOutputView eventOutputView = new EventOutputView();
    private OrderMenuOutputView orderMenuOutputView = new OrderMenuOutputView();
    private BenefitsOutputView benefitsOutputView = new BenefitsOutputView();

    private TotalOrderCalculator orderCalculator = new TotalOrderCalculator();

    public void start() {
        processOrder();
    }

    private void processOrder() {
        readOrderDetails();
        printOrderSummary();

        if (isBeverageOnlyOrder()) {
            messageOutputView.printBeverageOnlyMessage();
            return;
        }

        if (!isOrderWithinLimit()) {
            messageOutputView.printMenuQuantityLimitExceeded();
            return;
        }

        orderMenuOutputView.printTotalPrice(orderMap, menu);
        handleEventDetails();
    }

    private void readOrderDetails() {
        date = inputView.readDate();
        orderMap = inputView.readOrder();
        totalPrice = orderCalculator.calculateTotalPrice(orderMap, menu);
    }

    private void printOrderSummary() {
        eventOutputView.printEventPreview(date);
        orderMenuOutputView.printMenu(orderMap);
    }

    private boolean isBeverageOnlyOrder() {
        return BeverageValidator.containsOnlyBeverages(orderMap, menu);
    }

    private boolean isOrderWithinLimit() {
        return MenuQuantityValidator.isOrderWithinLimit(orderMap);
    }

    private void handleEventDetails() {
        isEventApplicable = TotalPriceValidator.isEventApplicable(totalPrice);
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
        int specialDiscount = SpecialDiscountCalculator.calculateSpecialDiscount(localDate);
        int champagneGift = GiftEventCalculator.calculateChampagneGift(totalPrice, orderMap);

        benefitsOutputView.printGiftEvent(champagneGift);
        benefitsOutputView.printBenefits(christmasDiscount, weekdayDiscount, weekendDiscount, specialDiscount, champagneGift);
        printTotalBenefitsAndDiscountedTotalPrice(totalPrice, christmasDiscount, weekdayDiscount, weekendDiscount, specialDiscount, champagneGift);
    }

    private void printTotalBenefitsAndDiscountedTotalPrice(int totalPrice, int christmasDiscount, int weekdayDiscount, int weekendDiscount, int specialDiscount, int champagneGift) {
        int totalBenefits = christmasDiscount + weekdayDiscount + weekendDiscount + specialDiscount + (CHAMPAGNE_PRICE * champagneGift);
        benefitsOutputView.printTotalBenefits(totalBenefits);

        int discountedTotalPrice = totalPrice - (totalBenefits - (CHAMPAGNE_PRICE * champagneGift));
        benefitsOutputView.printDiscountedTotalPrice(discountedTotalPrice);

        badge = BadgeCalculator.calculateBadge(totalBenefits);
        printEventBadge(badge);
    }

    private void printEventBadge(String badge) {
        eventOutputView.printEventBadge(badge);
    }

    private void printEventNotApplicableDetails(boolean isEventApplicable) {
        if (!isEventApplicable) {
            eventOutputView.printEventApplicableMessage();
            benefitsOutputView.printGiftEvent(0);
            benefitsOutputView.printBenefits(0, 0, 0, 0, 0);
            benefitsOutputView.printTotalBenefits(0);
            benefitsOutputView.printDiscountedTotalPrice(totalPrice);
            eventOutputView.printEventBadge("없음");
        }
    }
}