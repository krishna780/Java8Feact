import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MapEx {
    public static void main(String[] args) {
        List<Integer> list = List.of(15, 23, 100, 150, 136);
        double d = list.stream().filter(s -> s >= 100).collect(Collectors.summingDouble(k -> k));
        System.out.println(d);
    }
}
