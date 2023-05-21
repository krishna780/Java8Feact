package Application.Java11;

import java.util.Arrays;
import java.util.List;

public class ToArray {
    public static void main(String[] args) {
        List<Integer> list = List.of(3, 5, 2, 9, 10);
        Integer[] array = list.toArray(Integer[]::new);
        System.out.println(array);
        System.out.println(Arrays.toString(array));
    }
}
