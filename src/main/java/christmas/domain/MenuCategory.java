package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuCategory {
    private String categoryName;
    private List<MenuItem> items;

    public MenuCategory (String categoryName) {
        this.categoryName = categoryName;
        this.items = new ArrayList<>();
    }

    public void addItem(String itemName, int itemPrice) {
        items.add(new MenuItem(itemName, itemPrice));
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getItems() {
        return items;
    }
}
