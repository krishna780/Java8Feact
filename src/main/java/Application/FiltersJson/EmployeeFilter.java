package Application.FiltersJson;



public class EmployeeFilter {
    public static void main(String[] args) {
        Employee employee = Employee.builder()
                .id(123)
                .salary("1234567")
                .build();
        System.out.println(employee);
    }
}
