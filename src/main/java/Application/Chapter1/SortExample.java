package Application.Chapter1;

import java.util.Arrays;

public class SortExample {
    public static void main(String[] args) {
       String[] strings = {"new", "string", "dogs", "cat", "elephant", "active"};
            Arrays.sort(strings, new LengthComparator());
        Arrays.stream(strings).forEach(System.out::println);
    }

}
