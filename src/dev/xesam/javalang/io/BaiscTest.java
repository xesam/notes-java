package dev.xesam.javalang.io;

/**
 * Created by xe on 16-4-24.
 */
public class BaiscTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        System.setOut(null);
        System.out.println(1);//NullPointerException
    }
}
