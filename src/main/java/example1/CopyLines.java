package example1;

import java.io.*;

public class CopyLines {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStream=null;
        PrintWriter outputStream=null;

        try{
            inputStream=new BufferedReader(new FileReader("sample.txt"));
            outputStream=new PrintWriter(new FileWriter("sample-out2.txt"));

            String line;
            while((line=inputStream.readLine())!=null){
                outputStream.println(line);
            }
        }finally {
            if(inputStream!=null) inputStream.close();
            if(outputStream!=null) outputStream.close();
        }
    }
}
