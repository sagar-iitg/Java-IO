package example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NIOExample {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("E:\\language-concepts\\Java\\Java-IO\\src\\main\\example.txt");
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
