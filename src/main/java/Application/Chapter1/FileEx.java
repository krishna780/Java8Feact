package Application.Chapter1;

import java.io.File;
import java.util.Arrays;

public class FileEx {
    public static void main(String[] args) {
        File[] files = new File(".")
                .listFiles(File::isHidden);
        assert files != null;
        Arrays.stream(files).forEach(System.out::println);
    }
}
