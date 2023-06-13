package Application.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        List<String> country = new ArrayList<>();
                 country.add("Poland");
                country.add("Pakistan");
                 country.add("Australia");
                country.add("Uganda");
               country.add("China");
                 country.add("USA");country.add("Turkey");
                 System.out.println("List of Countries : " + country);
                // Now map() is used to transform the list of countries
                 List list = country.stream()
                         .filter(FlatMap::startWith)
                            .map(FlatMap::lengthen)
                            .filter(FlatMap::filterEx)
                            .collect(Collectors.toList());
                 System.out.println("Transformed list : " + list);
    }

    private static boolean startWith(String s) {
        return s.startsWith("A") || s.startsWith("U");
    }

    private static boolean filterEx(Integer integer) {
        if(!Objects.equals(integer, 6)){
            return true;
        }
        return false;
    }

    private static int lengthen(String s) {
        System.out.println(s);
        return s.length();
    }
}
