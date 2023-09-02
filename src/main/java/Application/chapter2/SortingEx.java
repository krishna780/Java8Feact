package Application.chapter2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortingEx {
    public static void main(String[] args) {
        String[] strings={"Connery", "Lazenby", "Moore",
                "Dalton", "Brosnan", "Craig"};

        String s = stringJoim(strings);

        List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore",
                "Dalton", "Brosnan", "Craig");
        bonds.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));

        IntStream.rangeClosed(1,10).forEach(System.out::println);


    }

    private static  String stringJoim(String... strings) {
       return Arrays.stream(strings).collect(Collectors.joining("-"));
    }
}
