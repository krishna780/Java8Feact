import java.util.List;

public class AnyMatchEx {
    public static void main(String[] args) {
        List<String> list = List.of("kri", "list", "123");
        boolean kri = list.stream().anyMatch(s -> s.equals("123"));
        if (kri) {
            System.out.println(list);
        } else {
            System.out.println("not match");
        }
    }
}
