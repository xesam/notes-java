package dev.xesam.javalang.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xesamguo@gmail.com on 17-3-20.
 */
public class CollectionsTest {
    @Test
    public void binarySearch() {
        List<Integer> a = new ArrayList<Integer>() {
            {
                add(1);
                add(3);
                add(6);
                add(9);
            }
        };
        int index_1 = Collections.binarySearch(a, 0);
        int insertion_point_1 = 0;
        Assert.assertEquals(-insertion_point_1 - 1, index_1);
        int index_2 = Collections.binarySearch(a, 2);
        int insertion_point_2 = 1;
        Assert.assertEquals(-insertion_point_2 - 1, index_2);
        int index_3 = Collections.binarySearch(a, 10);
        int insertion_point_3 = 4;
        Assert.assertEquals(-insertion_point_3 - 1, index_3);
        int index_4 = Collections.binarySearch(a, 6);
        Assert.assertEquals(2, index_4);
    }
}
