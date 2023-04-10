package Application;

import Application.programs.Dish;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static Application.programs.Dish.menu;
import static java.util.stream.Collectors.maxBy;

public class Java8Ex {
    public static void main(String[] args) {
        Optional<Dish> first = menu.stream().filter(Dish::isVegetarian).findFirst();

        Map<Dish.Type, Dish> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println(collect);


    }
}
