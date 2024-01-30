package filereading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTextFiles {
    public static void main(String[] args) {
        // Specify the path to the text file
        String filePath = "sample.txt";

        try (FileReader fileReader = new FileReader(filePath)) {
            int character;
            StringBuilder line = new StringBuilder();

            while ((character = fileReader.read()) != -1) {
                // Process each character
                if ((char) character == '\n') {
                    // Process the line
                    System.out.println(line.toString());
                    // Reset the StringBuilder for the next line
                    line = new StringBuilder();
                } else {
                    // Append the character to the current line
                    line.append((char) character);
                }
            }

            // Process the last line if not terminated with a newline character
            if (line.length() > 0) {
                System.out.println(line.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
