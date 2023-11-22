package christmas.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class EventPeriodValidatorTest {
    @Test
    void 이벤트_기간_내의_날짜인_경우_참_반환() {
        LocalDate currentDate = LocalDate.of(2023, 12, 15);

        boolean result = EventPeriodValidator.isEventPeriod(currentDate);

        assertTrue(result);
    }

    @Test
    void 이벤트_기간_이전의_날짜인_경우_거짓_반환() {
        LocalDate currentDate = LocalDate.of(2023, 11, 30);

        boolean result = EventPeriodValidator.isEventPeriod(currentDate);

        assertFalse(result);
    }

    @Test
    void 이벤트_기간_이후의_날짜인_경우_거짓_반환() {
        LocalDate currentDate = LocalDate.of(2024, 1, 15);

        boolean result = EventPeriodValidator.isEventPeriod(currentDate);

        assertFalse(result);
    }
}