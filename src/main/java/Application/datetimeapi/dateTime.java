package Application.datetimeapi;


import java.time.*;
import java.time.format.DateTimeFormatter;

public class dateTime {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate now = LocalDate.now();
        System.out.println(formatter.format(now));

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        System.out.println(timeFormatter.format(localTime));

        ZonedDateTime zoned = ZonedDateTime.now();
        ZoneOffset offset = zoned.getOffset();
        System.out.println(offset + " " + zoned.format(timeFormatter));
        ZonedDateTime dateTime = zoned.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println(timeFormatter.format(dateTime));

    }
};
