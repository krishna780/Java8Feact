package Application;

import Application.programs.Dish;

import java.util.Optional;

import static Application.programs.Dish.menu;

public class Java8Ex {
    public static void main(String[] args) {
        Optional<Dish> first = menu.stream().filter(Dish::isVegetarian).findFirst();
        first.ifPresent(System.out::println);
    }
}
