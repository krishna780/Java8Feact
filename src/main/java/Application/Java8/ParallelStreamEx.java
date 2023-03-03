package Application.Java8;

import java.util.List;

public class ParallelStreamEx {
    public static void main(String[] args) {
        Student student=new Student(1,"gopi",34);
        Student student1=new Student(2,"kri",32);
        Student student2=new Student(3,"ravi",33);
        Student student3=new Student(4,"hari",19);
        List<Student> studentList = List.of(student, student1, student2, student3);
        // studentList.parallelStream().forEach(System.out::println);
        studentList.stream().filter(s->s.getName().startsWith("ra")).forEach(System.out::println);
    }
}
