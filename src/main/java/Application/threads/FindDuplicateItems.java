package Application.threads;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicateItems {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        HashSet<Integer> hashSet=new HashSet<>();
        Set<Integer> collect = myList.stream()
                .filter(s -> !hashSet.add(s))
                          .collect(Collectors.toSet());
        hashSet.removeAll(collect);
        myList.stream().max(Integer::compareTo).ifPresent(System.out::println);

       String str="welcome to java";
       HashSet hs=new HashSet<>();
        Set<String> booleans = Arrays.stream(str.split("")).filter(s -> !hs.add(s))
                .collect(Collectors.toSet());
        System.out.println(booleans);
    }
}
