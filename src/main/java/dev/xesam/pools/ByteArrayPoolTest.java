package dev.xesam.pools;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xesamguo@gmail.com on 17-3-20.
 */
public class ByteArrayPoolTest {

    @Test
    public void test1() {
        ByteArrayPool pool = new ByteArrayPool(4096);
        byte[] b1 = pool.getBuf(1024);
        pool.returnBuf(b1);
        byte[] b2 = pool.getBuf(1024);
        Assert.assertEquals(true, b1 == b2);
    }

    @Test
    public void test2() {
        ByteArrayPool pool = new ByteArrayPool(4096);
        byte[] b1 = pool.getBuf(1024);
        pool.returnBuf(b1);
        byte[] b2 = pool.getBuf(1024);
        Assert.assertEquals(false, b1 != b2);
    }

    @Test
    public void test3() {
        ByteArrayPool pool = new ByteArrayPool(4096);
        byte[] b3 = pool.getBuf(8192);
        pool.returnBuf(b3);
        byte[] b4 = pool.getBuf(8192);
        Assert.assertEquals(false, b3 == b4);
    }

    @Test
    public void test4() {
        ByteArrayPool pool = new ByteArrayPool(4096);
        byte[] b3 = pool.getBuf(8192);
        pool.returnBuf(b3);
        byte[] b4 = pool.getBuf(8192);
        Assert.assertEquals(true, b3 != b4);
    }
}
