package Application.Stream;

import lombok.Data;

import java.util.List;

@Data

public class Department {
    private  String name;
    private List<Employee> employees;
}
