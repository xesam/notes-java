package io.github.xesam.lang.lang;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by xe on 14-11-20.
 */
public class ArrayTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 6);
        ListIterator<Integer> iterator = list.listIterator();

        System.out.println(iterator.next());
        System.out.println(iterator.previous());
    }
}
