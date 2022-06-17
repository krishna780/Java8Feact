package Application.programs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class HashMapSort {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("David", 95);
        scores.put("Jane", 80);
        scores.put("Mary", 97);
        scores.put("Lisa", 78);
        scores.put("Dino", 65);
        Stream<Map.Entry<String, Integer>> sorted = scores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue());
            sorted.forEach(System.out::println);
    }
}
