package Application.Chapter1;

import Application.programs.Dish;
import org.apache.logging.log4j.util.PropertySource;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Application.programs.Dish.menu;
import static java.util.stream.Collectors.*;


public class Example {
    public static void main(String[] args) throws IOException {

        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(toList(),
                e -> e.stream().sorted(Comparator.comparing(Dish::getCalories).reversed()).collect(toList()))));

        Map<Dish.Type, Dish> max = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(toList(), s -> s.stream().max(Comparator.comparing(Dish::getCalories)).get())));


        Map<Dish.Type, List<String>> collect1 = menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, collectingAndThen(toList(),
                e -> e.stream().sorted().collect(toList())))));

        Map<Dish.Type, Map<String, List<Dish>>> collect2 = menu.stream().collect(groupingBy(Dish::getType, groupingBy(Dish::getName, collectingAndThen(toList(), s ->
                s.stream().sorted(Comparator.comparing(Dish::getCalories)).collect(toList())))));


        Map<Dish.Type, List<String>> listMap = menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName,
                collectingAndThen(toList(), s -> s.stream().sorted(Comparator.naturalOrder()).collect(toList())))));
        System.out.println(listMap);

        String str="welcome to java";
        String[] split = str.split(" ");
        StringBuilder builder=new StringBuilder();
        for(String s:split){
            String[] split1 = s.split("");
            for(int i=split1.length-1;i>=0;i--){
                builder.append(split1[i]);
            }
            builder.append(" ");
        }
        System.out.println(builder.toString());




    }
}
