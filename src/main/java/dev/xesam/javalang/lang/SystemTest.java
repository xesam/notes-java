package dev.xesam.javalang.lang;

import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by xe on 2014/10/11.
 * xesamguo@gmail.com
 */
public class SystemTest {
    public static void main(String[] args) {
        printSystemProperties();
    }

    public static void printSystemProperties() {
        Properties properties = System.getProperties();
        Enumeration<Object> enumeration = properties.keys();

        while (enumeration.hasMoreElements()) {
            Object obj = enumeration.nextElement();
            System.out.println(obj + " <-> " + properties.get(obj));
        }
    }
}
