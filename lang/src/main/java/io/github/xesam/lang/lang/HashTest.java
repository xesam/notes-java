package io.github.xesam.lang.lang;

/**
 * Created by xesamguo@gmail.com on 17-3-23.
 */
public class HashTest {

    public static void main(String[] args) {
        HashTest hashTest = new HashTest();
        hashTest.testHash1();
    }

    public void testHash1() {
        String s1 = "abcd";
        String s2 = "abce";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
