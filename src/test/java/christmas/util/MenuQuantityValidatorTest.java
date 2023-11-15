package christmas.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MenuQuantityValidatorTest {
    @Test
    void 메뉴_수량_제한_미초과_테스트() {
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("아이스크림", 5);
        orderMap.put("레드와인", 2);

        boolean isWithinLimit = MenuQuantityValidator.isOrderWithinLimit(orderMap);

        assertTrue(isWithinLimit);
    }

    @Test
    void 메뉴_수량_제한_초과_테스트() {
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("아이스크림", 15);
        orderMap.put("레드와인", 8);

        boolean isWithinLimit = MenuQuantityValidator.isOrderWithinLimit(orderMap);

        assertFalse(isWithinLimit);
    }
}