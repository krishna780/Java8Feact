package Application.chapter2;

import Application.chapter4.Dish;
import org.springframework.lang.NonNull;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Application.chapter4.Dish.menu;

public class FilterEx {
    public static void main(String[] args) {

        if(menu.isPresent()) {
            List<Dish> collect = menu.get().stream()
                    .filter(s -> s.getCalories() > 400)
                    .sorted(Comparator.comparingInt(Dish::getCalories))
                    .collect(Collectors.toList());


            List<String> collect1 = menu.get().stream().filter(s -> s.getCalories() > 600)
                    .map(Dish::getName).collect(Collectors.toList());

            Map<Dish.Type, List<Dish>> collect2 = menu.get().stream().filter(Dish::isVegetarian)
                    .collect(Collectors.groupingBy(Dish::getType));

            List<Dish> collect3 = menu.get().stream().filter(s -> s.getType().equals(Dish.Type.MEAT) &&
                    s.getCalories()>500).collect(Collectors.toList());

            List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");

            Map<String, Long> collect5 = Arrays.stream("Lambdas".split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            Map<String, Long> collect4 = words.stream().map(w -> w.split(""))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            List<Integer> numbers1 = Arrays.asList(1, 2, 3);
            List<Integer> numbers2 = Arrays.asList(3, 4);

            List<Stream<int[]>> collect6 = numbers1.stream().map(i -> numbers2.stream().map(s -> new int[]{i, s})).collect(Collectors.toList());

            Optional<Integer> reduce = numbers1.stream().reduce(Integer::sum);


            Map<String, Map<String, Integer>> collect7 = menu.get().stream().collect(Collectors.groupingBy(dish -> {
                if (dish.getCalories() <= 400)
                    return "diet";
                else if (dish.getCalories() <= 700)
                    return "normal";
                else return "fat";
            }, Collectors.toMap(Dish::getName, Dish::getCalories)));

            Map<Dish.Type, Map<String, Map<String, Integer>>> collect8 = menu.get().stream()
                    .collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy((@NonNull Dish dish) -> {
                if (dish.getCalories() <= 400)
                    return "diet";
                else if (dish.getCalories() <= 700)
                    return "normal";
                else return "fat";
            }, Collectors.toMap(Dish::getName, Dish::getCalories))));



            System.out.println(collect8);

        }
    }
}
