package Application.Chapter1;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String[] args) {
        Apple apple = Apple.builder().size(10).name("a3").weight(4).build();
        Apple apple1 = Apple.builder().size(30).name("a7").weight(7).build();

        Apple apple2 = Apple.builder().size(20).name("a4").weight(54).build();

        Comparator<Apple> appleComparator = Comparator.comparing(Apple::getWeight);
        List<Apple> list = List.of(apple, apple1, apple2);
        //   list.stream(Dish).sorted(appleComparator).forEach(System.out::println);

        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));
        inventory.stream().filter(s -> s.getSize() > 150).filter(k -> k.getColor().equals(Color.GREEN)).forEach(System.out::println);

        List<Integer> integers = Arrays.asList(7, 3, 16, 9);
    }
}
