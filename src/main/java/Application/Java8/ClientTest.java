package Application.Java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ClientTest {
    public static void main(String[] args) {
        MyInterface myInterface=new MyInterfaceImpl();
        Integer maxNum = myInterface.getMaxNum(List.of(20, 5, 78, 26));
        MyInterface.greet("name");
        System.out.println(maxNum);

        Student student=new Student(123,"gopi",34);
        Student student1=new Student(123,"kri",32);
        Student student2=new Student(123,"ravi",33);
        Student student3=new Student(123,"hari",19);

        List<Student> list = new ArrayList<>(List.of(student, student1, student2, student3));
        List<Student> collect = list.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
        for (Student s:collect){
            System.out.println(s);
        }
    }
}

