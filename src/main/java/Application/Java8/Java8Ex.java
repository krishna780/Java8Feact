package Application.Java8;


import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class Java8Ex {
    public static void main(String[] args) {
        String str="krishna kanth gona";
        List<String> list=List.of("a","e","i","o", "u");
        String[] split = str.split("");
        List<String> collect = Arrays.stream(split)
                .filter(list::contains).collect(Collectors.toList());
        System.out.println(collect.toString());


    }
}
