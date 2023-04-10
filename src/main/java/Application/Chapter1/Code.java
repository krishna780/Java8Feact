package Application.Chapter1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Code {
    public static void main(String[] args) {
       Integer[] integers= {4,8,9,3,9,6};
        List<Integer> list= List.of(4,8,9,3,9,6);
        Object[] array = list.stream().sorted().toArray();
        Arrays.stream(array).forEach(System.out::print);
        System.out.println("---------");
        System.out.println(array[2]);
    }
}
