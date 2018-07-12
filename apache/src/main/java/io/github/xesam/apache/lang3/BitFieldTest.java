package io.github.xesam.apache.lang3;

import org.apache.commons.lang3.BitField;
import org.junit.Assert;
import org.junit.Test;

public class BitFieldTest {
    @Test
    public void bitField1() {
        BitField top = new BitField(0b1000);
        BitField right = new BitField(0b0100);
        BitField bottom = new BitField(0b0010);
        BitField left = new BitField(0b0001);

        Assert.assertFalse(top.isSet(0b111));
        Assert.assertTrue(right.isSet(0b111));
        Assert.assertTrue(bottom.isSet(0b111));
        Assert.assertTrue(left.isSet(0b111));

        Assert.assertEquals(0b0110, left.clear(0b111));

        Assert.assertEquals(0b0001, left.setBoolean(0b0000, true));

    }
}
