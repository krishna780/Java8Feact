package Application.Java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface MyInterface {

    default List<Student> sortStudent(List<Student> studentList) {
        Collections.sort(studentList, Comparator.comparing(Student::getName));
        return studentList;
    }
    static void greet(String name){
        System.out.println("welcome"+name);
    }
    public Integer getMaxNum(List<Integer> list);
}
