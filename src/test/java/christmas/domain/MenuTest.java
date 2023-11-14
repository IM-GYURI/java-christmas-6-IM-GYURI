package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.List;

class MenuTest {
    @Test
    void 비어있지_않은_목록_반환() {
        List<MenuCategory> 메뉴 = Menu.createMenu();
        assertNotNull(메뉴);
        assertFalse(메뉴.isEmpty());
    }

    @Test
    void 디저트_항목일때_참_반환() {
        assertTrue(Menu.isDessertMenuItem("초코케이크"));
    }

    @Test
    void 디저트_항목이_아닐때_거짓_반환() {
        assertFalse(Menu.isDessertMenuItem("티본스테이크"));
    }
}