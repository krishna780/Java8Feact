package Application.datetimeapi;

import java.time.*;

public class DurationEx {
    public static void main(String[] args) {
        LocalDateTime oldDate = LocalDateTime.of(2016, Month.SEPTEMBER, 12, 21, 20);
        LocalDateTime newDate = LocalDateTime.of(2022,Month.JULY,03, 16,58);
        Duration duration = Duration.between(oldDate, newDate);

        LocalDate oldDate1 = LocalDate.of(2016, Month.SEPTEMBER, 12);
        LocalDate newDate2 = LocalDate.of(2022,Month.JULY,03);
        Period between = Period.between(oldDate1, newDate2);
        System.out.println(between.getYears());
        System.out.println(duration.toString());
    }
}
