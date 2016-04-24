package dev.xesam.javalang.lang;

/**
 * Created by xe on 16-4-22.
 */
public class StringTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        //下面的 split 操作在不同的系统上，结果不一致
        System.out.println("1".split("").length);
        System.out.println("s".split("").length);
        System.out.println("中".split("").length);
        System.out.println("中国".split("").length);

        for (char c : "中国".toCharArray()) {
            System.out.println(c);
        }
    }
}
