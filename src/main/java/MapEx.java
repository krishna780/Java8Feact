import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MapEx {
    public static void main(String[] args) {
        List<Dish> list=Dish.menu;
        HashMap<String, Integer> collect = list.stream()
                .sorted(Comparator.comparingInt(Dish::getCalories))
                .collect(Collectors.toMap(Dish::getName,
                        Dish::getCalories, (o1, o2) -> o2, HashMap::new));
        System.out.println(collect);
    }
}
