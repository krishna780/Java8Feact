import java.util.*;
import java.util.stream.Collectors;

public class StreamEx {
    public static void main(String[] args) {
        List<Integer> ls = Dish.menu.stream().filter(d -> d.getCalories() > 450)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getCalories)
                .collect(Collectors.toList());

        Map<Dish.Type, List<Dish>> map = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));

        List<Dish> list = Dish.menu.stream().filter(d -> !d.isVegetarian()).collect(Collectors.toList());

        Optional<Integer> max = Dish.menu.stream().max(Comparator.comparingInt(Dish::getCalories)).map(Dish::getCalories);

        Optional<Dish> collect = Dish.menu.stream().filter(Dish::isVegetarian).findAny();
        if (collect.isPresent()) {
            System.out.println(collect);
        }
    }
}
