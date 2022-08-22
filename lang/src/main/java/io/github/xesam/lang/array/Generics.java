package io.github.xesam.lang.array;

import java.lang.reflect.Array;

public class Generics {
    @SuppressWarnings({"unchecked", "hiding"})
    public static <T> T[] getArray(Class<T> componentType, int length) {
        return (T[]) Array.newInstance(componentType, length);
    }

    public static void main(String[] args) {
        String[] strings = getArray(String.class, 10);
        strings[0] = "a";
        System.out.println(strings[0]);
    }
}
