package example1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacter {
    public static void main(String[] args) throws IOException {
        FileReader inputstream=null;
        FileWriter outputstream=null;

        try{
            inputstream=new FileReader("sample.txt");
            outputstream=new FileWriter("sample-out1.txt");
            int c;
            while((c=inputstream.read())!=-1){
                outputstream.write(c);
            }
        }finally {
            if(inputstream!=null) inputstream.close();
            if(outputstream!=null) outputstream.close();
        }
    }
}
