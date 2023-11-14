package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class MenuCategoryTest {
    @Test
    void 카테고리_이름_확인() {
        String categoryName = "<메인>";
        MenuCategory category = new MenuCategory(categoryName);
        assertEquals(categoryName, category.getCategoryName());
    }

    @Test
    void 아이템_추가_및_메인_확인() {
        MenuCategory category = new MenuCategory("<메인>");
        String itemName = "티본스테이크";
        int itemPrice = 55_000;

        category.addItem(itemName, itemPrice);

        assertTrue(category.containsMainMenu(itemName));
    }

    @Test
    void 아이템이_없는_경우_확인() {
        MenuCategory category = new MenuCategory("<메인>");
        String itemName = "티본스테이크";

        assertFalse(category.containsMainMenu(itemName));
    }
}