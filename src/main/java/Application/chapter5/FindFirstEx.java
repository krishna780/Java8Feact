package Application.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindFirstEx {
    public static void main(String[] args) {
        List<Integer> asList = Arrays.asList(3, 5, 6, 2, 6);
        asList.stream().map(x->x*x).filter(x->x%3==1).findFirst().ifPresent(System.out::println);
        asList.stream().map(x->x*x).filter(x->x%3==1).forEach(System.out::println);
        asList.stream().reduce(Integer::sum).ifPresent(System.out::println);

    }
}
