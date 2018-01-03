package dev.xesam.javalang.reflect.sample;

/**
 * Created by xe on 18-1-3.
 */
public class Api {
    private static String HOST = "123";
    private final int port = 80;

    public static void inspect() {
        System.out.println(HOST);
    }

    public void inspectSelf() {
        System.out.println(port);
    }
}
