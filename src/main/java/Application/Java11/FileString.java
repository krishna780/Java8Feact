package Application.Java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileString {
    public static void main(String[] args) throws IOException {
        Path wellcomeToJav = Files.writeString(Path.of("data.txt"), "wellcome to jav", StandardOpenOption.APPEND);
        System.out.println(wellcomeToJav);

        String readString = Files.readString(Path.of("data.txt"));
        System.out.println(readString);
    }
}
