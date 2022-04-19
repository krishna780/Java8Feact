import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByValueExample {
    public static void main(String[] args) {
        Map<String, Integer> unSortMap = new HashMap<>();
        unSortMap.put("z", 10);
        unSortMap.put("b", 5);
        unSortMap.put("a", 6);
        unSortMap.put("c", 20);
        unSortMap.put("d", 1);
        unSortMap.put("e", 7);
        unSortMap.put("y", 8);
        unSortMap.put("n", 99);
        unSortMap.put("g", 50);
        unSortMap.put("m", 2);
        unSortMap.put("f", 9);
        Map<String, Integer> result =  unSortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                        (o1,o2)->o2, HashMap::new));
        System.out.println(result);

    }
}
