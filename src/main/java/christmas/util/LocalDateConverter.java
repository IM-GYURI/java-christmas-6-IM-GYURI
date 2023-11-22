package christmas.util;

import java.time.LocalDate;

public class LocalDateConverter {
    private static final int year = 2023;
    private static final int month = 12;

    public static LocalDate convertToLocalDate(int date)  {
        LocalDate localDate = LocalDate.of(year, month, date);
        return localDate;
    }
}