package Application.threads;

import Application.programs.Employee;
import Application.programs.Employee2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args) {
        String str = "krishna kanth";
        String[] split = str.split("");
        List<String> collect =
                Arrays.stream(split)
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(s -> s.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
        List<Integer> list = List.of(1, 4, 5, 6, 7, 89, 3, 5, 2);
        Stream<Integer> stream =
                list.stream()
                        .collect(
                                Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(s -> s.getValue() == 1)
                        .map(Map.Entry::getKey);
        System.out.println(stream.collect(Collectors.toList()));
        Employee employee = new Employee(1L, 234);
        Employee2 employee2 = new Employee2(2L, 4566);
        Map<Object, Object> employees =
                Stream.of(employee, employee2)
                        .collect(Collectors.toMap(Employee::getEmpId, Employee::getSalary));

        Set<String> set = new HashSet<>();
        for (String s : split) {
            if (set.contains(s.trim())) {

                set.removeAll(List.of(s, ""));
            } else {
                set.add(s.trim());
            }
        }
        System.out.println(set);
    }

}
