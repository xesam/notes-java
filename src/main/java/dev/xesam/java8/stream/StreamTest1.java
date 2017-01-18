package dev.xesam.java8.stream;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by xesamguo@gmail.com on 17-1-18.
 */
public class StreamTest1 {
    @Test
    public void test1() {
        long a = Arrays.asList(1, 2, 3, 4).stream()
                .filter(x -> x > 2)
                .count();
        assertEquals(2, a);
    }

}
