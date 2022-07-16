import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JavaFile {
    public static void main(String[] args) throws IOException {
        String list = Files.readString(Path.of("src/main/java/Application/Files"));
        String[] split = list.split("\\R");
        for (String st : split) {
            StrBoolean(st);
        }
    }

    private static void StrBoolean(String st) {
        String[] split = st.split("\\n\n");
        for (String s : split)
            System.out.println(s);
    }
}
