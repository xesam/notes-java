package dev.xesam.javalang.tools;

import java.net.URI;

/**
 * Created by xesamguo@gmail.com on 16-8-16.
 */
public class UriTest {
    public static void main(String[] args) {
        String a = "app://dev.xesam.che/dev.intent.splash";
        URI uri = URI.create(a);
        System.out.println(uri.getScheme());
        System.out.println(uri.getHost());
        System.out.println(uri.getPath());
    }
}
