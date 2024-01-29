package filereading;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromTextFiles {

    public static void main(String[] args) throws IOException {
        String fileName="sample.txt";

        System.out.println("Method 1: Using Path.lines");
        Files.lines(Path.of(fileName)).forEach(System.out::println);

        System.out.println("Method 2: Using Path.readAllLines");
        List<String> lines=Files.readAllLines(Path.of(fileName));
        lines.forEach(System.out::println);

        System.out.println("Method 3: Using BufferedReader.lines.forEach");

        new BufferedReader(new FileReader(fileName)).lines().forEach(System.out::println);

        System.out.println("Method 4: Old fashioned way");

        BufferedReader bf=new BufferedReader(new FileReader(fileName));
        String line;
        while((line=bf.readLine())!=null){
            System.out.println(line);
        }
        try {
            FileInputStream fis=new FileInputStream(fileName);
            for(int n=fis.read();n!=-1;n=fis.read()){
                System.out.println(n);
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
