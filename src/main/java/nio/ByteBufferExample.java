package nio;

import java.nio.ByteBuffer;

public class ByteBufferExample {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(5);

        buffer.put((byte) 'A');
        buffer.put((byte) 'B');

        buffer.clear();

        buffer.put((byte) 'X');

        System.out.println((char) buffer.get(0));
        System.out.println((char) buffer.get(1));
    }
}
