package Application.programs;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilterEx {
    public static void main(String[] args) {
        Optional<List<String>> list = Optional.of(List.of("123", "krishna", "ravi"));
        List<List<String>> collect = list.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
