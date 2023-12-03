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
        String line=reader.readLine();
        System.out.println("---");
        while(line!=null)
        {
            System.out.println(line);
            line=reader.readLine();


        }
        System.out.println("-----");
        //method2
        Path path = Paths.get("Transpose.txt");
        List<String> lines = Files.readAllLines(path);
        for (String i : lines) {
            // Process each line here
            System.out.println(i);
        }

        //method 3
        System.out.println("-----");

        BufferedInputStream bf=new BufferedInputStream(new FileInputStream("Transpose.txt"));
        byte[] buffer=new byte[8];
        int bytesRead;
        //System.out.println(new String(buffer,0,bf.read(buffer)));
        while ((bytesRead=bf.read(buffer))!=-1){
            // Example: Convert bytes to String and print
            String data = new String(buffer, 0, bytesRead);
            System.out.print(data);
        }



    }
}
