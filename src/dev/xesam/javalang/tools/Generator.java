package dev.xesam.javalang.tools;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xe xesamguo@gmail.com on 14-9-25.
 */
public class Generator {

    private static final char a = 'a';
    private static final char A = 'A';
    private static final char z = 'z';
    private static final char Z = 'Z';


    public <T> T[] stringArray(T s, int length) {
        List<T> list = new ArrayList<T>(length);
        for (int i = 0; i < length; ++i) {
            list.add(s);
        }
        T[] array = (T[]) Array.newInstance(String.class, length);
        list.toArray(array);
        return array;
    }

    public String[] alphabetArray(int length) {
        return null;
    }

    public static void main(String[] args) {
        Generator generator = new Generator();
        final String T = "t";
        String[] array = generator.<String>stringArray(T, 10);
        assert array.length == 10 : "length error";
        for (String string : array) {
            assert T.equals(string) : "content is not match";
        }
    }

    public static int[] fromTo() {
        return new int[]{};
    }

    public static char[] fromTo(char from, char to) {
        int c = from - to;
        char[] chars = new char[Math.abs(c) + 1];
        for (char index = 0, i = from; i <= to; index++) {
            chars[index] = i;
            if (c < 0) {
                i++;
            } else {
                i--;
            }
        }
        return chars;
    }

    public static String[] a2z() {
        char[] chars = fromTo('a', 'z');
        String[] strings = new String[chars.length];
        for (int i = 0, size = strings.length; i < size; i++) {
            strings[i] = String.valueOf(chars[i]);
        }
        return strings;
    }
}
