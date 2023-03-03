package Application.programs;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CollectEx {
    public static void main(String[] args) {
        List<String> list = List.of("kri", "list", "123");
        list.stream().map(s -> s.toUpperCase(Locale.ROOT)).forEach(System.out::println);
        long count = list.size();
        System.out.println(count);
    }
}
