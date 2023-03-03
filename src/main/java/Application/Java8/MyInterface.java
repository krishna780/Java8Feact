package Application.Java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface MyInterface {

    default List<Student> sortStudent(List<Student> studentList) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return studentList;
    }
    static void greet(String name){
        System.out.println("welcome"+name);
    }
    public Integer getMaxNum(List<Integer> list);
}
