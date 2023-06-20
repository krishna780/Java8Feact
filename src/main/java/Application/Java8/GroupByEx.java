package Application.Java8;

import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GroupByEx {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("anana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99")));
        Map<String, Optional<Item>> collect = items.stream().collect(Collectors.groupingBy(Item::getName,
                Collectors.maxBy(Comparator.comparing(Item::getQty))));


        Map<String, List<String>> collect1 = items.stream().collect(Collectors.groupingBy(Item::getName,
                Collectors.collectingAndThen(
                        Collectors.toList(), s -> s.stream().map(Item::getName).sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList()))));
        ConcurrentMap<Integer, List<BigDecimal>> collect2 = items.stream()
                .collect(Collectors.groupingByConcurrent(Item::getQty, Collectors.collectingAndThen(Collectors.toList(),
                        s -> s.stream().map(Item::getPrice).sorted().collect(Collectors.toList()))));


        Map<BigDecimal, String> collect3 = items.stream().collect(Collectors.toMap(Item::getPrice,
                 Item::getName));
        Map<BigDecimal, List<String>> collect4 = items.stream().collect(Collectors.groupingBy(Item::getPrice,
                Collectors.collectingAndThen(Collectors.toList(), k -> k.stream().map(Item::getName)
                        .sorted(Collections.reverseOrder()).collect(Collectors.toList()))));

        System.out.println(collect4);

    }
}
