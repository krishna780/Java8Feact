package Application.datetimeapi;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class dateTime {
    public static void main(String[] args) {
        List<Integer> integers=List.of(2,3,4,5);
        List<Integer> collect = integers.stream().map(s -> s * s).collect(Collectors.toList());
        System.out.println(collect);
    }
};
