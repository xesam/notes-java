package io.github.xesam.lang.net;

import io.github.xesam.lang.tools.L;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xe on 16-4-19.
 */
public class UrlTest {
    public static void main(String[] args) {
        UrlTest urlTest = new UrlTest();
        urlTest.test1();
    }

    public void test1() {
        try {
            URL url = new URL("http://tv.cntv.cn/video/C14124/2bfc0aeae7294db89fda19988a9c29b4");
            L.log(url);
            L.log(url.getPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
