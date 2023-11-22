package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MenuItemTest {
    @Test
    void 메뉴_아이템_이름_확인() {
        String itemName = "티본스테이크";
        int itemPrice = 55_000;
        MenuItem menuItem = new MenuItem(itemName, itemPrice);

        assertEquals(itemName, menuItem.getName());
    }

    @Test
    void 메뉴_아이템_가격_확인() {
        String itemName = "티본스테이크";
        int itemPrice = 55_000;
        MenuItem menuItem = new MenuItem(itemName, itemPrice);

        assertEquals(itemPrice, menuItem.getPrice());
    }
}
