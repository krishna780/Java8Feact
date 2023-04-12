package Application;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        List<Integer> integers1=List.of(2,6,8,5,2);
        List<Integer> integers2 = List.of(12, 6, 10, 5, 2, 5);

        List<Integer> collect = Stream.of(integers1, integers2).flatMap(Collection::stream).collect(Collectors.toList());
        Map<Integer, Long> collected = collect.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));



        System.out.println(collected);
    }
}
