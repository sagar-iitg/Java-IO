package example;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class PrintWriterExample {

    public static void main(String[] args) {
        // Specify the file path
        String filePath = "output.txt";

        // Creating a PrintWriter object with FileWriter
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Writing data to the file
            writer.println("Hello, PrintWriter!");
            writer.println("This is an example.");
            writer.println("Java programming is fun!");

            //System.out.println("Data written to the file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
