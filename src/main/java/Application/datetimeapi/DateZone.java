package Application.datetimeapi;

import java.time.*;
import java.util.Date;

public class DateZone {
    public static void main(String[] args) {
        Date date = new Date();
        ZonedDateTime zonedDateTime = date.toInstant().atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        ZonedDateTime dateTime = ZonedDateTime.now();
        System.out.println(dateTime.withZoneSameInstant(ZoneId.of("Asia/Kolkata")));

        LocalDateTime localDateTime = LocalDateTime.now();
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.of("-05:10"));
        System.out.println(offsetDateTime);
    }
}
