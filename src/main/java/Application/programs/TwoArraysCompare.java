package Application.programs;

import java.util.List;

public class TwoArraysCompare {
    public static void main(String[] args) {
        List<String> list = List.of("wel", "name");
        List<String> ls = List.of("name", "wel");
        System.out.println(arrayCom(list, ls));

    }

    private static boolean arrayCom(List<String> list, List<String> ls) {
        if (list.size() != ls.size()) {
            return false;
        }
        for (String st : list) {
            if (!ls.contains(st)) {
                return false;
            }
        }
        return true;
    }
}
