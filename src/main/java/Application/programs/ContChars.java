package Application.programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContChars {
    public static void main(String[] args) {
        String str="abcdABCDabcd";
        String[] split = str.split("");
        HashMap<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(),
                HashMap::new, Collectors.counting()));
        System.out.println(collect);
    }
}
