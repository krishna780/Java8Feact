import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JavaFile {
    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(Path.of("src/main/java/Application/Files"));
        System.out.println(list);
    }
}
