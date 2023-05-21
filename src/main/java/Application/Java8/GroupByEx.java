package Application.Java8;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


public class GroupByEx {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99")));
        Map<String, IntSummaryStatistics> collect = items.stream().collect(Collectors.groupingBy(Item::getName,
                Collectors.summarizingInt(Item::getQty)));


        Map<String, List<String>> collect1 = items.stream().collect(Collectors.groupingBy(Item::getName,
                Collectors.collectingAndThen(
                        Collectors.toList(), s -> s.stream().map(Item::getName).sorted(Comparator.reverseOrder())
                                .collect(Collectors.toList()))));


    }
}