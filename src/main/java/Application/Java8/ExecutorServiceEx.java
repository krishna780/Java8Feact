package Application.Java8;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExecutorServiceEx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Student student=new Student(123,"gopi",34);
        Student student1=new Student(123,"kri",32);
        Student student2=new Student(123,"ravi",33);
        Student student3=new Student(123,"hari",19);
        List<Student> list = new ArrayList<>(List.of(student, student1, student2, student3));
        Runnable runnable= () -> {
        List<Student> collect = list.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
            for (Student s:collect){
              //  System.out.println(s);
            }
        };
       ExecutorService executor= Executors.newFixedThreadPool(10);
        executor.submit(runnable);
        List<String> ls= ExecutorServiceEx.getPersonName(list, Student::getName);

        System.out.println(ls);

    }

    private static List<String> getPersonName(List<Student> list, Function<Student, String> getName) {
        return list.stream().map(Student::getName).collect(Collectors.toList());
    }
}
