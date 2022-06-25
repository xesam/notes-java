package io.github.xesam.lang.nio;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by xe xesamguo@gmail.com on 14-9-26.
 */
public class BufferTest {
    public static void main(String[] args) throws IOException {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    public static ByteBuffer getBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 'H').put((byte) 'E').put((byte) 'L').put((byte) 'L').put((byte) 'O');
        return buffer;
    }

    public static void test1() {
        System.out.println("-------test1------");
        ByteBuffer buffer = getBuffer();
        Inspector.inspect(buffer);
    }

    public static void test2() {
        System.out.println("-------test2------");
        ByteBuffer buffer = getBuffer();
        buffer.get(0);
        Inspector.inspect(buffer);
    }

    public static void test3() {
        System.out.println("-------test3------");
        ByteBuffer buffer = getBuffer();
        buffer.get();
        Inspector.inspect(buffer);
    }

    public static void test4() {
        System.out.println("-------test4------");
        ByteBuffer buffer = getBuffer();
        buffer.flip();
        Inspector.inspect(buffer);
        buffer.flip();
        Inspector.inspect(buffer);
    }

    public static void test5() {
        System.out.println("-------test5------");
        ByteBuffer buffer = getBuffer();
        buffer.position(3);
        Inspector.inspect(buffer);

    }

    public static void test6() {
        System.out.println("-------test6------");
        ByteBuffer buffer = getBuffer();
        buffer.rewind();
        Inspector.inspect(buffer);
        buffer.position(3);
        Inspector.inspect(buffer);
        buffer.rewind();
        Inspector.inspect(buffer);
    }

    public static void test7() {
        System.out.println("-------test7------");
        ByteBuffer buffer = getBuffer();
        buffer.clear();
        Inspector.inspect(buffer);
    }

    public static void test8() {
        System.out.println("-------test8------");
        ByteBuffer buffer = getBuffer();
        Inspector.inspect(buffer);
        buffer.put((byte) 'a');
        Inspector.inspect(buffer);
        buffer.compact();
        Inspector.inspect(buffer);
    }

}
