package Application.datetimeapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class DateTimeForBuilder {
    public static void main(String[] args) {
        DateTimeFormatter formatterBuilder=new DateTimeFormatterBuilder()
                .appendPattern("dd MMM").parseDefaulting(ChronoField.YEAR,2020)
                .toFormatter(Locale.US);
        String str="02 Jan";
        LocalDate parse = LocalDate.parse(str, formatterBuilder);
        System.out.println(parse);
        System.out.println(formatterBuilder.format(parse));
    }
}
