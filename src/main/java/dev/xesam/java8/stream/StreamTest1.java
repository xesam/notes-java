package dev.xesam.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by xesamguo@gmail.com on 17-1-18.
 */
public class StreamTest1 {
    @Test
    public void test1() {
        long a = Stream.of(1, 2, 3, 4)
                .filter(x -> x > 2)
                .count();
        assertEquals(2, a);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<String> vals = Arrays.stream(arr).mapToObj(value -> "str_" + value).collect(Collectors.toList());
        System.out.println(vals);
    }

}
