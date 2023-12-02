package example;

import java.io.File;

public class DumpRoots
{
   public static void main(String[] args)
   {
      File[] roots = File.listRoots();
      for (File root: roots){
         System.out.println(root);
         System.out.println(root.getUsableSpace());
         System.out.println(root.getFreeSpace());
         System.out.println(root.getTotalSpace());

      }


   }
}