package file;

import java.nio.file.Path;

class FileProperty{


    public static void main(String[] args) {
        
        Path cwd = Path.of("").toAbsolutePath();
        System.out.println(cwd.toString());
    }
    
}