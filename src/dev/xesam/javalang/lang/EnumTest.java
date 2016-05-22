package dev.xesam.javalang.lang;

import org.junit.Test;

/**
 * Created by xe xesamguo@gmail.com on 15-8-20.
 */
public class EnumTest {
    @Test
    public void test_1() {
        System.out.println(Season.SPRING);
    }
}

enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER
}