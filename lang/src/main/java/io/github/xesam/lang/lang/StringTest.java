package io.github.xesam.lang.lang;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        String url = "http://xesam.github.io/html/css/app.css?v=v2";
        try {
            URL uri = new URL(url);
            System.out.println(getV(uri));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private static Pattern pattern = Pattern.compile("(?:\\?|&)v=([^=]+)");

    public static String getV(URL uri) {
        Matcher matcher = pattern.matcher(uri.getQuery());
        if (matcher.find()) {
            if (matcher.groupCount() == 1) {
                return matcher.group(1);
            }
        }
        return null;
    }
}
