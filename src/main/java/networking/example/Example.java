package networking.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {

        try{
            InetAddress address=InetAddress.getByName("www.google.com");
            System.out.println(address);
            InetAddress[] hostName=InetAddress.getAllByName("www.fb.com");
            System.out.println(Arrays.toString(hostName));
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
