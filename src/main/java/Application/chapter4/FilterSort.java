package Application.chapter4;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Application.chapter4.Dish.menu;

public class FilterSort {
    public static void main(String[] args) {
        Optional<List<String> >collect = Optional.of(menu.get().stream().filter(s -> s.getCalories() > 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(Collectors.toList()));

        List<String> list = menu.get().parallelStream().filter(s -> s.getCalories() > 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(Collectors.toList());

        Map<Dish.Type, List<Dish>> listMap = menu.get().stream().collect(Collectors.groupingBy(Dish::getType));

        List<String> limit = menu.get().parallelStream().filter(s -> s.getCalories() > 300).limit(3).map(Dish::getName).collect(Collectors.toList());
        Optional<List<String>> asList =Optional.of(Arrays.asList("java", "as", "list"));
        asList=Optional.of(asList.get().stream().sorted().collect(Collectors.toList()));

        List<Dish> dishes = menu.get().stream().filter(s -> !s.getType().equals(Dish.Type.MEAT)).collect(Collectors.toList());
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> integerStream = words.stream().filter(StringUtils::isNotEmpty).map(String::length).collect(Collectors.toList());

        String[] arrayOfWords = {"Goodbye", "World"};
        List<String> stringList = Arrays.stream(arrayOfWords).map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().map(n->n*n).forEach(System.out::println);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

            List<int[]> collect1 = numbers1.stream().flatMap(s -> numbers2.stream().map(k -> new int[]{s, k})).collect(Collectors.toList());
     for (int[] list1:collect1){
       System.out.println(Arrays.toString(list1));
      }
    }
}
