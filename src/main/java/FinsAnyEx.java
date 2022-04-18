import java.util.List;
import java.util.Optional;

public class FinsAnyEx {
    public static void main(String[] args) {
        List<String> list= List.of("kri", "list", "123");
        Optional<String> any = list.stream().findAny();
        Optional<String> first = list.stream().findFirst();
        System.out.println(any.get());
        System.out.println(first.get());
    }
}
