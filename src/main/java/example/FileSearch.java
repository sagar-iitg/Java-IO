package example;

import java.io.File;
import java.sql.Array;
import java.util.Arrays;

public class FileSearch {
    public static void main(String[] args) {

        String directoryPath = "E:\\One Drive\\Documents\\R"; // Replace with the directory path you want to search in
        String fileName = "README.md"; // Replace with the file name you're looking for
        File ans=searchForFile(new File(directoryPath),fileName);
        System.out.println(ans);

    }

    public static File searchForFile(File directory, String fileName) {

        if(directory.isDirectory()){

            File[] files = directory.listFiles();
            System.out.println(Arrays.toString(files));

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // Recursively search in nested directories
                        File result=searchForFile(file, fileName);
                        if(result!=null) return result;

                    } else if (file.getName().equals(fileName)) {
                        // Found the file
                        return file;
                    }
                }
            }
        }
        return  null;




    }
}
