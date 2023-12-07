package example;

import java.io.PrintWriter;
import java.io.IOException;

public class PrintWriterExample1 {

    public static void main(String[] args) {
        // Specify the file path
        String filePath = "output1.txt";

        try (PrintWriter writer = new PrintWriter(filePath)) {
            // Writing data to the file
            writer.println("PrintWriter Example");
            writer.println("Writing to a file in Java");
            writer.println("No FileWriter used");

            System.out.println("Data written to the file: " + filePath);

            // Simulating an exception during file writing
           // simulateException();

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static void simulateException() throws IOException {
        // Simulating an exception during file writing
        throw new IOException("Simulated exception during file writing");
    }
}
