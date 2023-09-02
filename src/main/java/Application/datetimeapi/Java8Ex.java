package Application.datetimeapi;

import Application.programs.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Application.programs.Dish.menu;
import static java.util.stream.Collectors.*;

public class Java8Ex {
    public static void main(String[] args) {
        Optional<Dish> first = menu.stream().filter(Dish::isVegetarian).findFirst();

        Map<Dish.Type, Dish> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        Map<Dish.Type, List<Map.Entry<String, Integer>>> collect1 = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(toList(), k -> k.stream()
                        .collect(toMap(Dish::getName, Dish::getCalories)).entrySet().stream()
                        .sorted(Map.Entry.comparingByValue()).collect(toList()))));

        System.out.println(collect);


    }
}
