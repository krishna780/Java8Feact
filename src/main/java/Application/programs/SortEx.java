package Application.programs;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEx {
    public static void main(String[] args) {
        List<Integer> list = List.of(9, 5, 4, 2, 7, 1, 5, 8);
        List<Integer> collect = list.stream()
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
