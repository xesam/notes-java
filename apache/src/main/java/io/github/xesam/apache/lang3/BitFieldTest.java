package io.github.xesam.apache.lang3;

import org.apache.commons.lang3.BitField;
import org.junit.Test;

public class BitFieldTest {
    @Test
    public void bitField1() {
        BitField bitField = new BitField(31);
        System.out.println(bitField.isSet(2));
    }
}
