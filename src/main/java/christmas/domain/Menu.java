package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static void main(String[] args) {
        MenuCategory appetizerCategory = new MenuCategory("<애피타이저>");
        appetizerCategory.addItem("양송이수프", 6_000);
        appetizerCategory.addItem("타파스", 5_500);
        appetizerCategory.addItem("시저샐러드", 8_000);

        MenuCategory mainCategory = new MenuCategory("<메인>");
        mainCategory.addItem("티본스테이크", 55_000);
        mainCategory.addItem("바비큐립", 54_000);
        mainCategory.addItem("해산물파스타", 35_000);
        mainCategory.addItem("크리스마스파스타", 25_000);

        MenuCategory dessertCategory = new MenuCategory("<디저트>");
        dessertCategory.addItem("초코케이크", 15_000);
        dessertCategory.addItem("아이스크림", 5_000);

        MenuCategory beverageCategory = new MenuCategory("<음료>");
        beverageCategory.addItem("제로콜라", 3_000);
        beverageCategory.addItem("레드와인", 60_000);
        beverageCategory.addItem("샴페인", 25_000);

        List<MenuCategory> menu = new ArrayList<>();
        menu.add(appetizerCategory);
        menu.add(mainCategory);
        menu.add(dessertCategory);
        menu.add(beverageCategory);

        for (MenuCategory category : menu) {
            System.out.println(category.getCategoryName());
            for (MenuItem item : category.getItems()) {
                System.out.println(item.getName() + "(" + item.getPrice() + ")");
            }
            System.out.println();
        }
    }
}
