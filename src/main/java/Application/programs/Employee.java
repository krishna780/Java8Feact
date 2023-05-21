package Application.programs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    Long empId;
    int salary;

    public Employee(long empId) {
        this.empId=empId;
    }
}
