package dev.xesam.pools;

/**
 * Created by xesamguo@gmail.com on 17-3-20.
 */
public class ByteArrayPoolTest {
    public static void main(String[] args) {
        ByteArrayPool pool = new ByteArrayPool(4096);
        byte[] b1 = pool.getBuf(1024);
        byte[] b2 = pool.getBuf(8192);
        pool.returnBuf(b1);
        pool.returnBuf(b2);
        System.out.println("end");

    }
}
