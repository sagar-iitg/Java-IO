package example;

import java.io.*;

public class Example2 {

    public static void main(String[] args) throws IOException {

       // File file=new File("E:\\language-concepts\\Java\\Java-IO\\src\\main\\example.txt");
        FileReader f=new FileReader("E:\\language-concepts\\Java\\Java-IO\\src\\main\\example.txt");
        BufferedReader bf=new BufferedReader(f);

        String line;

        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
        bf.close();


    }
}
