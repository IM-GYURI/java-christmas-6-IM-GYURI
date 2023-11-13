package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static final String DESSERT_CATEGORY = "<디저트>";
    private static final List<MenuCategory> MENU = createMenu();

    public static List<MenuCategory> createMenu() {
        List<MenuCategory> menu = new ArrayList<>();

        menu.add(createCategory("<애피타이저>", "양송이수프", 6_000, "타파스", 5_500, "시저샐러드", 8_000));
        menu.add(createCategory("<메인>", "티본스테이크", 55_000, "바비큐립", 54_000, "해산물파스타", 35_000, "크리스마스파스타", 25_000));
        menu.add(createCategory("<디저트>", "초코케이크", 15_000, "아이스크림", 5_000));
        menu.add(createCategory("<음료>", "제로콜라", 3_000, "레드와인", 60_000, "샴페인", 25_000));

        return menu;
    }

    private static MenuCategory createCategory(String categoryName, Object... items) {
        MenuCategory category = new MenuCategory(categoryName);
        for (int i = 0; i < items.length; i += 2) {
            String itemName = (String) items[i];
            int price = (int) items[i + 1];
            category.addItem(itemName, price);
        }
        return category;
    }


    public static List<MenuCategory> getMenu() {
        return MENU;
    }

    public static boolean isDessertMenuItem(String menuName) {
        return getMenu().stream()
                .anyMatch(category -> category.getItems().stream()
                        .anyMatch(item -> item.getName().equals(menuName) && DESSERT_CATEGORY.equals(category.getCategoryName())));
    }
}
