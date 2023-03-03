package Application.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static Application.programs.Dish.menu;

public class SumOfNum {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3,4);
        List<Integer> numbers2 = Arrays.asList(3, 4,5,6);

        List<int[]> collect = numbers1.stream().flatMap(i -> numbers2.stream().filter(j -> (i + j) == 10)
                .map(j -> new int[]{i, j})).collect(Collectors.toList());
        for (int[] in:collect){
            System.out.println(Arrays.toString(in));
        }
        boolean b = menu.stream().anyMatch(Dish::isVegetarian);
        boolean match = menu.stream().noneMatch(s -> s.getCalories() > 400);
        System.out.println(match);
    }
}
