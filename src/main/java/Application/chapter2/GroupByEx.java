package Application.chapter2;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static Application.chapter2.Employee.getEmpList;

public class GroupByEx {
    public static void main(String[] args) {
        Map<String, Optional<Employee>> collect = getEmpList().stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));

        Map<String, List<String>> collect1 = getEmpList().stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println(collect1);
    }
}
