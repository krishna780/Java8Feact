package Application.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEmp {
    public static void main(String[] args) {
        Employee employee1=new Employee("ravi",20);
        Employee employee2=new Employee("krishna",
                10);
        Employee employee3=new Employee("hari",30);
        Department department=new Department();
        department.setName("Human Resources");
        department.setEmployees(List.of(employee1,employee2,employee3));
        Department department1=new Department();
        department1.setName("Accounting");
        department1.setEmployees(List.of(employee1));

        List<Department> departmentList=new ArrayList<>();
        departmentList.add(department);
        departmentList.add(department1);
        departmentList.stream().filter(z->z.getName().equalsIgnoreCase("Accounting")).flatMap(s->s.getEmployees().stream()
                .filter(k->k.getName().equalsIgnoreCase("hari")))
                .forEach(System.out::println);


    }
}
