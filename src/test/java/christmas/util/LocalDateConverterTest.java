package christmas.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class LocalDateConverterTest {
    @Test
    void 정상적인_날짜_변환_테스트() {
        int date = 15;

        LocalDate convertedDate = LocalDateConverter.convertToLocalDate(date);

        assertEquals(2023, convertedDate.getYear());
        assertEquals(12, convertedDate.getMonthValue());
        assertEquals(15, convertedDate.getDayOfMonth());
    }
}