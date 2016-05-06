package dev.xesam.javalang.nio;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by xe xesamguo@gmail.com on 14-9-26.
 */
public class BufferTest {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 'H').put((byte) 'E').put((byte) 'L').put((byte) 'L').put((byte) 'O');
        Inspector.inspect(buffer);
        buffer.get(0);
        Inspector.inspect(buffer);
        buffer.get();
        Inspector.inspect(buffer);
        buffer.flip();
        Inspector.inspect(buffer);
        buffer.position(3);
        Inspector.inspect(buffer);
        buffer.rewind();
        Inspector.inspect(buffer);
        buffer.clear();
        Inspector.inspect(buffer);

    }

}
