package dev.xesam.javalang.lang;

import java.io.Console;

/**
 * Created by xe on 2014/9/21.
 * xesamguo@gmail.com
 */
public class PrimitiveType {
    public static void main(String[] args) {
        PrimitiveType primitiveType = new PrimitiveType();
        primitiveType.byteType();
        Console console;
    }

    private void byteType() {
        byte b1 = 1;
        byte b2 = 2;
        byte b3 = (byte) (b1 + b2);
        byte b4 = 1 + 2;
        System.out.println(b3);
    }

    private void charType() {
        char c = '中';
        System.out.println(c);
        System.out.println(String.format("0x%x", (int) c));
        char c1 = 0x4e2d;
        System.out.println(c1);
        System.out.println('\u4e2d');
    }
}
