package example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadingTextFile {
    public static void main(String[] args) throws IOException {
        //method1
        BufferedReader reader=new BufferedReader(new FileReader("Transpose.txt"));
        String line;
        while((line=reader.readLine())!=null)
        {
            System.out.println(line);

        }
        System.out.println("-----");
        //method2
        Path path = Paths.get("Transpose.txt");
        List<String> lines = Files.readAllLines(path);
        for (String i : lines) {
            // Process each line here
            System.out.println(i);
        }
    }
}
