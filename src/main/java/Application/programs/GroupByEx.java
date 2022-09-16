package Application.programs;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByEx {
    public static void main(String[] args) {
        Map<Dish.Type, List<String>> collect = Dish.menu.stream().collect(Collectors.groupingBy(
                Dish::getType, Collectors.mapping(Dish::getName,
                        Collectors.toList())));

        Map<Dish.Type, Map<Integer, List<String>>> mapMap = Dish.menu.stream().collect(Collectors.groupingBy(
                Dish::getType, Collectors.groupingBy(Dish::getCalories, Collectors.mapping(Dish::getName, Collectors.toList()))));

        System.out.println(mapMap);
    }
}
