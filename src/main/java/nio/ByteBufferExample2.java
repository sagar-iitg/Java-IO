package nio;

import java.nio.ByteBuffer;

public class ByteBufferExample2 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(2);

        buffer.put((byte) 'A');
        System.out.println(buffer.get(0));
        buffer.put(new byte[] {0});
        System.out.println(buffer.get(1));
        //buffer.put((byte) 'B');

    }
}
