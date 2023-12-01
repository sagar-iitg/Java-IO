package example;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Example3 {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("img.jpg");
             BufferedInputStream bis = new BufferedInputStream(fis))
        {
            // Read bytes from file.
            int _byte;
            // -1 signifies EOF
            while ((_byte = bis.read()) != -1)  {
                System.out.println(_byte);


            }
        }
        catch (IOException ioe)
        {
            // Handle exception.
            System.out.println(ioe.toString());
        }
    }
}
